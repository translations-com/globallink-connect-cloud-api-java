package org.gs4tr.gcc.restclient.request;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UploadFileRequest extends GCRequest {

	private byte[] contents;
	private String fileName;
	private String fileType;
	private String uniqueIdentifier;
	private String contextUrl;
	private String submitter;
	private String path;
	private String metadata;
	private String publicPreviewUrl;
	private String sourceLocale;
	private String changeDetectionData;
	private Long sequenceNumber;

	public UploadFileRequest(String filePath, String name, String fileType) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new IllegalArgumentException("File does not exist - " + filePath);
		}
		if (StringUtils.isNullOrEmpty(fileType)) {
			throw new IllegalArgumentException("File type is required");
		}

		this.contents = Files.readAllBytes(Paths.get(filePath));
		this.fileType = fileType;
		this.fileName = name;
		if (StringUtils.isNullOrEmpty(name)) {
			this.fileName = file.getName();
		}
	}

	public UploadFileRequest(byte[] contents, String name, String fileType) {
		this.contents = contents;
		if (contents == null || contents.length <= 0) {
			throw new IllegalArgumentException("Byte array with contents is empty");
		}
		if (StringUtils.isNullOrEmpty(fileType)) {
			throw new IllegalArgumentException("File type is required");
		}
		if (StringUtils.isNullOrEmpty(name)) {
			throw new IllegalArgumentException("File name is required");
		}

		this.fileType = fileType;
		this.fileName = name;
	}

	public UploadFileRequest(String filePath, String name, String fileType, String uniqueIdentifier, String contextUrl,
			String submitter, String path, Map<String, Object> metadata, Long sequenceNumber)
			throws IOException {
		this(filePath, name, fileType);

		this.uniqueIdentifier = uniqueIdentifier;
		this.contextUrl = contextUrl;
		this.submitter = submitter;
		this.path = path;
		if (metadata != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			this.metadata = objectMapper.writeValueAsString(metadata);
		}
		this.sequenceNumber = sequenceNumber;
	}

	public UploadFileRequest(byte[] contents, String name, String fileType, String uniqueIdentifier, String contextUrl,
			String submitter, String path, Map<String, Object> metadata, Long sequenceNumber)
			throws IOException {
		this(contents, name, fileType);

		this.uniqueIdentifier = uniqueIdentifier;
		this.contextUrl = contextUrl;
		this.submitter = submitter;
		this.path = path;
		if (metadata != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			this.metadata = objectMapper.writeValueAsString(metadata);
		}
		this.sequenceNumber = sequenceNumber;
	}

	public void setCustomAttributesAsJson(String attributesJson) {
		this.metadata = attributesJson;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.putAll(super.getParameters());

		parameters.put("name", this.fileName);
		parameters.put("file_type", this.fileType);
		if (!StringUtils.isNullOrEmpty(this.uniqueIdentifier)) {
			parameters.put("unique_identifier", this.uniqueIdentifier);
		}
		if (!StringUtils.isNullOrEmpty(this.contextUrl)) {
			parameters.put("context_url", this.contextUrl);
		}
		if (!StringUtils.isNullOrEmpty(this.submitter)) {
			parameters.put("submitter", this.submitter);
		}
		if (!StringUtils.isNullOrEmpty(this.path)) {
			parameters.put("path", this.path);
		}
		if (!StringUtils.isNullOrEmpty(this.metadata)) {
			parameters.put("metadata", this.metadata);
		}
		if (this.sequenceNumber != null && this.sequenceNumber > 0) {
			parameters.put("sequence_number", this.sequenceNumber);
		}
		if (!StringUtils.isNullOrEmpty(this.getPublicPreviewUrl())) {
			parameters.put("public_preview_url", this.getPublicPreviewUrl());
		}
		if (!StringUtils.isNullOrEmpty(this.getSourceLocale())) {
			parameters.put("source_locale", this.getSourceLocale());
		}
		if (!StringUtils.isNullOrEmpty(this.getChangeDetectionData())) {
			parameters.put("change_detection_data", this.getChangeDetectionData());
		}

		parameters.put("file", this.contents);
		return parameters;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}

	public String getContextUrl() {
		return contextUrl;
	}

	public void setContextUrl(String contextUrl) {
		this.contextUrl = contextUrl;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public Long getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getPublicPreviewUrl() {
		return publicPreviewUrl;
	}

	public void setPublicPreviewUrl(String publicPreviewUrl) {
		this.publicPreviewUrl = publicPreviewUrl;
	}

	public String getSourceLocale() {
		return sourceLocale;
	}

	public void setSourceLocale(String sourceLocale) {
		this.sourceLocale = sourceLocale;
	}

	public String getChangeDetectionData() {
		return changeDetectionData;
	}

	public void setChangeDetectionData(String changeDetectionData) {
		this.changeDetectionData = changeDetectionData;
	}

}
