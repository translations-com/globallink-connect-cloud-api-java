# Changelog

## [3.0.0](https://github.com/translations-com/globallink-connect-cloud-api-java/tree/3.0.0)

**General:**

Added support for api/v3. Authentication is now based on JWT tokens

**New API methods:**

- `String getConnectorsInfo()` returns connector info json
- `List<String> getDataStoreKeys()` provides list of existing datastore keys
- `String getDataStoreEntryJson(String key)` returns datastore for specified store key in json format
- `<T> List<T> getDataStoreEntryAsList(String key, Class<T> clazz)` returns datastore for specified store key as List<T>
- `<T> T getDataStoreEntryAsObject(String key, Class<T> clazz)` returns datastore for specified store key as <T>
- `MessageResponse deleteDataStoreKeys(List<String> keys)` removes datastore for specified key
- `MessageResponse addOrUpdateDataStore(String key, Object data)` creates or updates datastore for specified store key with specified data
- `InputStream downloadDeliverable(SubmissionRequest request)` downloads deliverables for specified submission
- `MessageResponse addLog(List<LogEntry> logEntries)` allows to store log messages on server. Suggested to stack up to 100 messages and upload them in one request. New model `LogEntry` added
- `MessageResponse notify(NotifyRequest request)` sends email notifications to configured recipients
- `List<ContentHistoryData> checkHistory(CheckHistoryRequest request)` returns history for specified content uid in specified source and target locales. New model `ContentHistoryData` and `HistoryItem` added
- `MessageResponse updateSubmissionAttributes(UpdateSubmissionAttributeRequest request)` and `MessageResponse updateSubmissionAttributes(long submissionId, Map<String, Object> attributes)` allows to update custom attributes of specified submission
- `List<FailedTask> updateTaskMetadata(UpdateTasksMetadataRequest request)` allows to update metadata of specified list of task ids. New model `FailedTasks` added


**Updated API methods:**

- `void logout()` removed. No need to logout anymore
- `String getConnectorsDataStore()` now replaced with methods to work with specific datastore keys
- `MessageResponse setConnectorsDataStore(String dataStore)` now replaced with methods to work with specific datastore keys
- `TasksResponseData getJobTasks(JobRequest jobRequest)` replaced with `TasksResponseData getJobTasks(JobTasksRequest jobRequest)`
- `List<SubmissionWordCountData> getSubmissionWordCount(Long submissionId)` replaced with `List<WordCount> getSubmissionWordCount(Long submissionId)`


**Changes in models:**

- Updated: `List<String> pdSubmissionIds` to type `Map<String, String>` in `GCSubmission`
- Updated: `String status` to `String state` in `GCTask`
- Removed `String publicPreviewUrl` from `GCTask`
- Removed `String contextUrl` from `GCTask`
- Added `String connectorKey` to `GCSubmission` to provide information about connector in which submission was created
- Added `Locale sourceLocale` to `GCTask` to provide task source locale
- Added `Map<String, Object> metadata` to `GCTask` to provide task metadata
- Added `String connectorKey` to `GCTask`  to provide information about connectorKey in which task was created


**Changes in requests:**

- Updated: `String locale` to `String sourceLocale` in `TaskListRequest`
- Removed: `String[] contentIds` from `TaskListRequest`
- Added: Request `JobListRequest` now allows to specify list of connector keys in `connectorIds` property. Response will contain jobs from all specified connectors
- Added: Request `SubmissionsListRequest` now allows to specify list of connector keys in `List<String> connectorIds` property
- Added: Request `SubmissionsListRequest` now allows to search for submission with specific attributes in `Map<String, Object> attributes`
- Added: Request `SubmissionsListRequest` now allows to search for submission with isRedelivery flag using `Integer isRedelivery`
- Added: Request `SubmissionsListRequest` now allows to specify search string using `String searchString`
- Added: Request `SubmissionsListRequest` now has `List<String> searchConfigKeys`. Used with `searchString` to specify in which config fields search should be performed
- Added: Request `TaskListRequest` now allows to specify list of connector keys in `connectorIds` property. Response will contain tasks from all specified connectors
- Added: Request `TaskListRequest` now has new fields `String[] targetLocales`, `String submissionName`, `String path`, `String submitter`, `String searchString`, `String[] searchMetadataKeys` 
- Added: `String name` to request `UploadFileContextRequest` 


**Changes in responses:**

- Updated: Response subclass `ConnectorsConfigAvailableStates` now returns statuses as `List<String>` instead of `List<Status>`
- Added: Response class `ConnectorsConfigResponseData` for method `getConnectorsConfig()` now has new fields `Boolean isMultiSourceLocaleSupported`, `String connectorName`, `String connectorType`

