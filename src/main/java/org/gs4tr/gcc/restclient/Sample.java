package org.gs4tr.gcc.restclient;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import org.gs4tr.gcc.restclient.model.GCTask;
import org.gs4tr.gcc.restclient.model.TaskStatus;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponseData;
import org.gs4tr.gcc.restclient.request.TaskListRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sample {

    public static void main(String[] args) {

//	GCConfig config = new GCConfig("https://connect-qa.translations.com/api/v2/", "anaik", "Gl0bal!nk", null,
//		"serg");
//	String connectorKey = "0eda21fe211c307e6853f3c332f7b5af";
//	GCExchange x = new GCExchange(config);
//	x.getConfig().setConnectorKey(connectorKey);
	/*
	 * List<Connector> cons = x.getConnectors(); for (Connector c : cons) {
	 * System.out.println(c.getConnectorName() + ":" + c.getConnectorKey());
	 * } x.getConfig().setConnectorKey(connectorKey);
	 * ConnectorsConfigResponseData ccrd = x.getConnectorsConfig(); if
	 * (ccrd.getFileTypes() != null) { for (FileType type :
	 * ccrd.getFileTypes()) { System.out.println(type.getFileType()); } }
	 * x.getContentList(); x.getContextConfigs(); JobsResponseData jobs =
	 * x.getJobsList(new JobListRequest());
	 * x.getJobState(jobs.getJobs().get(0).getJobId());
	 * x.getJobTasks(jobs.getJobs().get(0).getJobId());
	 * x.getJobWordCount(jobs.getJobs().get(0).getJobId());
	 * SubmissionsResponseData srd = x.getSubmissionsList(new
	 * SubmissionsListRequest());
	 * 
	 * x.getSubmissionJobs(srd.getSubmissions().get(0).getSubmissionId());
	 * x.getSubmissionState(srd.getSubmissions().get(0).getSubmissionId());
	 * x.getSubmissionTasks(srd.getSubmissions().get(0).getSubmissionId());
	 * x.getSubmissionWordCount(srd.getSubmissions().get(0).getSubmissionId(
	 * ));
	 */
	TaskListRequest trr = new TaskListRequest();
	trr.setTaskStatuses(new TaskStatus[] { TaskStatus.Completed });
	trr.setPageNumber(1L);
	trr.setPageSize(50L);
	try {
	    writeValueAsString(trr);
	} catch (IllegalArgumentException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (IllegalAccessException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (InvocationTargetException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (IntrospectionException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	if(true)
	    return;
	
//	TasksResponseData trd = x.getTasksList(trr);
//	if (trd.getTasks() != null && trd.getTasks().size() > 0) {
//	    try {
//		for (int i = 0; i < 30; i++) {
//		    GCTask t = trd.getTasks().get(i);
//		    System.out.println(t.getNodeType() + ":" + t.getName());
//		    InputStream inputStream = x.downloadTask(t.getTaskId());
//		    File folder = new File("tasks");
//		    if (!folder.exists()) {
//			folder.mkdirs();
//		    }
//		    File f = new File("tasks" + File.separator + t.getTaskId() + "_" + t.getName());
//
//		    FileOutputStream fos;
//
//		    fos = new FileOutputStream(f);
//
//		    int read = 0;
//		    byte[] buffer = new byte[32768];
//		    while ((read = inputStream.read(buffer)) > 0) {
//			fos.write(buffer, 0, read);
//		    }
//
//		    fos.close();
//		    inputStream.close();
//		}
//		// x.confirmTask(t.getTaskId());
//	    } catch (FileNotFoundException e) {
//		e.printStackTrace();
//	    } catch (IOException e) {
//		e.printStackTrace();
//	    }
//	}
	/*
	 * UploadFileContextRequest ufcr; String contextUrl = null; try { ufcr =
	 * new
	 * UploadFileContextRequest("d:\\Downloads\\pss1385770610779892748.zip",
	 * ContextType.ZIP); contextUrl = x.uploadContext(ufcr); } catch
	 * (IOException e) { e.printStackTrace(); }
	 * 
	 * UploadFileRequest upload; String uploadedContentId = null; try {
	 * upload = new UploadFileRequest(
	 * "e:\\workspace_mars\\gcc-cli-trunk\\resources\\sources\\Just translate me2003 (2).doc"
	 * , "just translate", "DOC"); upload.setContextUrl(contextUrl);
	 * uploadedContentId = x.uploadContent(upload); } catch (IOException e)
	 * { e.printStackTrace(); }
	 * 
	 * UploadContentReferenceRequest reference; try { reference = new
	 * UploadContentReferenceRequest(
	 * "e:\\workspace_mars\\gcc-cli-trunk\\resources\\sources\\Just translate me2003 (2).doc"
	 * , "just translate"); x.uploadContentReference(reference); } catch
	 * (IOException e) { e.printStackTrace(); }
	 * 
	 * int dueDateOffset = 5; Date dueDate = new Date((new Date()).getTime()
	 * + (1000 * 60 * 60 * 24 * dueDateOffset)); String sourceLocale = null;
	 * String targetLocale = null; for(LocaleConfig lc :
	 * ccrd.getSupportedLocales()){ if(lc.getIsSource()){ sourceLocale =
	 * lc.getPdLocale(); } else { targetLocale = lc.getPdLocale(); }
	 * if(sourceLocale!=null && targetLocale != null){ break; } }
	 * SubmissionSubmitRequest ssr = new SubmissionSubmitRequest(
	 * "test submission", dueDate, sourceLocale,
	 * Arrays.asList(targetLocale), Arrays.asList(uploadedContentId)); Long
	 * submissionId = x.submitSubmission(ssr);
	 * System.out.println(submissionId);
	 */
	//x.logout();

	/*
	 * JobListRequest r = new JobListRequest(1L, 3L, new JobStatus[] {
	 * JobStatus.Approval, JobStatus.Analyzed }, 5L, "subm"); try {
	 * writeValueAsString(r); } catch (IllegalArgumentException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (InvocationTargetException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (IntrospectionException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

    }
    
    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
	    fields.addAll(Arrays.asList(type.getDeclaredFields()));

	    if (type.getSuperclass() != null) {
	        getAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}

    private static void writeValueAsString(Object r)
	    throws IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
StringBuffer out = new StringBuffer();
	List<Field> fields = new ArrayList<Field>();
	fields = getAllFields (fields, r.getClass());
//	BeanInfo info = Introspector.getBeanInfo(r.getClass());  
//        List<PropertyDescriptor> props = Arrays.asList(info.getPropertyDescriptors());  
//        for (PropertyDescriptor pd : props) 
//        {  
//            System.out.println(pd.getName()+":"+pd.getPropertyType());
//            System.out.println(pd.getReadMethod()+":"+pd.getWriteMethod());
//            Enumeration<String> attrs = pd.attributeNames();
//            while(attrs.hasMoreElements()){
//        	String attr = attrs.nextElement();
//        	System.out.println("ATTR:"+attr+":"+JsonProperty.class.getName());
//        	if(attr.equals(JsonProperty.class.getName())){
//        	    JsonProperty jp = (JsonProperty)pd.getValue(attr);
//        	    System.out.println("JSON NAME:"+jp.value());
//        	}
//            }
//        }
	out.append("{");
	for (Field f : fields) {
	    System.out.println("--------------------");
	    /*Optional<PropertyDescriptor> epd = props.stream().filter(p -> p.getName().equals(f.getName())).findAny();
	    PropertyDescriptor pd = null;
	    if(epd.isPresent() && epd.get().getReadMethod()!=null){
		pd = new PropertyDescriptor(f.getName(), r.getClass(), epd.get().getReadMethod().getName(), epd.get().getWriteMethod()!=null?epd.get().getWriteMethod().getName():null);
	    } else {
		pd = new PropertyDescriptor(f.getName(), r.getClass());
	    }*/
	    //System.out.println(f.getName() + ":" + f.getType());
	    //System.out.println(pd.getReadMethod().invoke(r));
	    String name = f.getName();
	    if (f.isAnnotationPresent(JsonProperty.class)) {
		name = f.getAnnotation(JsonProperty.class).value();
		System.out.println("n2:" + name);
	    }
f.setAccessible(true);
	    if (f.getType().equals(String.class)) {
		//System.out.println("STRING " + name + ":" + f.get(r));
	    } else if (f.getType().equals(Long.class)) {
		System.out.println("LONG " + name + ":" + f.get(r));
	    } else if (f.getType().isArray()) {
		System.out.println("ARR " + name + ":" + f.get(r));
		//Object[] object=(Object[])field.get(obj);
		Object[] boxedArray = (Object[])f.get(r);
		if(boxedArray!=null){
		for (int index = 0; index < boxedArray.length; index++) {
		    //boxedArray[index] = Array.get(f, index); // automatic boxing
		    System.out.println(index + ":" + boxedArray[index]);
		}
		}
		// System.out.println("ARR2 " + name + ":" +
		// pd.getReadMethod().invoke(r));
		// return boxedArray;
	    } else {
		writeValueAsString("UNKNOWN "+f.get(r));
	    }
	}
    }

}
