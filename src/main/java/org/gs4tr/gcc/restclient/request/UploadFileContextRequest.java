package org.gs4tr.gcc.restclient.request;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadFileContextRequest extends GCRequest {

	@JsonProperty("type")
	private String xsltType;
	private ContextType contextType;
	@JsonProperty("preview_file")
	private byte[] contents;
	@JsonProperty("html_file_name")
	private String htmlFileName;
	@JsonProperty("unique_id")
	private String uniqueId;
	@JsonIgnore
	private String fileName = "index.html";

	public enum ContextType {
		HTML, ZIP, XSLT
	}

	public UploadFileContextRequest(String filePath, ContextType contextType) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new IllegalArgumentException("File does not exist - " + filePath);
		}
		this.fileName = file.getName();
		if (contextType == null) {
			throw new IllegalArgumentException("Context type is required");
		}
		this.contents = Files.readAllBytes(Paths.get(filePath));
		this.contextType = contextType;
	}

	public UploadFileContextRequest(byte[] contents, ContextType contextType) {
		this.contents = contents;
		if (contents == null || contents.length <= 0) {
			throw new IllegalArgumentException("Byte array with contents is empty");
		}
		if (contextType == null) {
			throw new IllegalArgumentException("Context type is required");
		}
		this.contextType = contextType;
	}

	public UploadFileContextRequest(String filePath, ContextType contextType, String htmlFileName, String uniqueId)
			throws IOException {
		this(filePath, contextType);
		this.htmlFileName = htmlFileName;
		this.uniqueId = uniqueId;
	}

	public UploadFileContextRequest(byte[] contents, ContextType contextType, String htmlFileName, String uniqueId) {
		this(contents, contextType);
		this.htmlFileName = htmlFileName;
		this.uniqueId = uniqueId;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.putAll(super.getParameters());
		// parameters.put("type", this.contextType.name());
		parameters.put("preview_file", this.contents);
		if (!StringUtils.isNullOrEmpty(this.htmlFileName)) {
			parameters.put("html_file_name", this.htmlFileName);
		} else {
			parameters.put("ignore_file_name", this.fileName);
		}
		if (!StringUtils.isNullOrEmpty(this.uniqueId)) {
			parameters.put("unique_id", this.uniqueId);
		}
		if (contextType.equals(ContextType.XSLT)) {
			if (StringUtils.isNullOrEmpty(this.xsltType)) {
				throw new IllegalStateException("For XSLT context type it's required to set xsltType");
			}
			parameters.put("type", this.xsltType);
		}

		return parameters;
	}

	public ContextType getContextType() {
		return contextType;
	}

	public void setContextType(ContextType contextType) {
		this.contextType = contextType;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(String filePath) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new IllegalArgumentException("File does not exist - " + filePath);
		}
		this.contents = Files.readAllBytes(Paths.get(filePath));
	}

	public void setContents(byte[] contents) {
		if (contents == null || contents.length <= 0) {
			throw new IllegalArgumentException("Byte array with contents is empty");
		}
		this.contents = contents;
	}

	public String getHtmlFileName() {
		return htmlFileName;
	}

	public void setHtmlFileName(String htmlFileName) {
		this.htmlFileName = htmlFileName;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getXsltType() {
		return xsltType;
	}

	public void setXsltType(String xsltType) {
		this.xsltType = xsltType;
	}

}
