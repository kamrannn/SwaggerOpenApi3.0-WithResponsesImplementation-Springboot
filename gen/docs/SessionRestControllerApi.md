# SessionRestControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteAllSessions**](SessionRestControllerApi.md#deleteAllSessions) | **DELETE** /sessions | 
[**listAllSessions**](SessionRestControllerApi.md#listAllSessions) | **GET** /sessions | 


<a name="deleteAllSessions"></a>
# **deleteAllSessions**
> deleteAllSessions()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SessionRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    SessionRestControllerApi apiInstance = new SessionRestControllerApi(defaultClient);
    try {
      apiInstance.deleteAllSessions();
    } catch (ApiException e) {
      System.err.println("Exception when calling SessionRestControllerApi#deleteAllSessions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All sessions are successfully deleted |  -  |
**500** | Internal Server Error |  -  |

<a name="listAllSessions"></a>
# **listAllSessions**
> Session listAllSessions(convenor, module)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SessionRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    SessionRestControllerApi apiInstance = new SessionRestControllerApi(defaultClient);
    Long convenor = 56L; // Long | 
    String module = "module_example"; // String | 
    try {
      Session result = apiInstance.listAllSessions(convenor, module);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SessionRestControllerApi#listAllSessions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **convenor** | **Long**|  | [optional]
 **module** | **String**|  | [optional]

### Return type

[**Session**](Session.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | Successfully fetched the list of sessions |  -  |
**500** | Internal Server Error |  -  |

