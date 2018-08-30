package org.gs4tr.gcc.restclient.request;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.util.StringUtils;

public class UploadContentReferenceRequest extends GCRequest {

    private byte[] contents;
    private String fileName;
    
    public UploadContentReferenceRequest(String filePath) throws IOException {
	this(filePath, null);
    }

    public UploadContentReferenceRequest(String filePath, String name) throws IOException {
	File file = new File(filePath);
	if (!file.exists()) {
	    throw new IllegalArgumentException("File does not exist - " + filePath);
	}

	this.contents = Files.readAllBytes(Paths.get(filePath));
	this.fileName = name;
	if (StringUtils.isNullOrEmpty(name)) {
	    this.fileName = file.getName();
	}
    }

    public UploadContentReferenceRequest(byte[] contents, String name) {
	this.contents = contents;
	if (contents == null || contents.length <= 0) {
	    throw new IllegalArgumentException("Byte array with contents is empty");
	}
	if (StringUtils.isNullOrEmpty(name)) {
	    throw new IllegalArgumentException("File name is required");
	}

	this.fileName = name;
    }


    public Map<String, Object> getParameters() {
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.putAll(super.getParameters());

	parameters.put("name", this.fileName);
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

}
