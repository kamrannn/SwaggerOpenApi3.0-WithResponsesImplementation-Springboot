# ConvenorRestControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create1**](ConvenorRestControllerApi.md#create1) | **POST** /convenors | 
[**delete1**](ConvenorRestControllerApi.md#delete1) | **DELETE** /convenors | 
[**list1**](ConvenorRestControllerApi.md#list1) | **GET** /convenors | 
[**modulesTaughtByConvenor1**](ConvenorRestControllerApi.md#modulesTaughtByConvenor1) | **GET** /convenors/{id}/modules | 
[**update1**](ConvenorRestControllerApi.md#update1) | **PUT** /convenors | 


<a name="create1"></a>
# **create1**
> Convenor create1(convenor)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ConvenorRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ConvenorRestControllerApi apiInstance = new ConvenorRestControllerApi(defaultClient);
    Convenor convenor = new Convenor(); // Convenor | 
    try {
      Convenor result = apiInstance.create1(convenor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConvenorRestControllerApi#create1");
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
 **convenor** | [**Convenor**](Convenor.md)|  |

### Return type

[**Convenor**](Convenor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**500** | Internal Server Error |  -  |
**200** | Successfully created the Convenor |  -  |

<a name="delete1"></a>
# **delete1**
> delete1(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ConvenorRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ConvenorRestControllerApi apiInstance = new ConvenorRestControllerApi(defaultClient);
    Long id = 56L; // Long | 
    try {
      apiInstance.delete1(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConvenorRestControllerApi#delete1");
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
 **id** | **Long**|  |

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
**200** | Successfully deleted the convenor from the database |  -  |
**404** | There is no convenor against this ID |  -  |
**500** | Internal Server Error |  -  |

<a name="list1"></a>
# **list1**
> Convenor list1()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ConvenorRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ConvenorRestControllerApi apiInstance = new ConvenorRestControllerApi(defaultClient);
    try {
      Convenor result = apiInstance.list1();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConvenorRestControllerApi#list1");
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

[**Convenor**](Convenor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successfully fetched the list of convenors |  -  |
**500** | Internal Server Error |  -  |
**404** | There is no convenor in the database |  -  |

<a name="modulesTaughtByConvenor1"></a>
# **modulesTaughtByConvenor1**
> Module modulesTaughtByConvenor1(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ConvenorRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ConvenorRestControllerApi apiInstance = new ConvenorRestControllerApi(defaultClient);
    Long id = 56L; // Long | 
    try {
      Module result = apiInstance.modulesTaughtByConvenor1(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConvenorRestControllerApi#modulesTaughtByConvenor1");
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
 **id** | **Long**|  |

### Return type

[**Module**](Module.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**500** | Internal Server Error |  -  |
**200** | Successfully fetched the list of modules Taught by Convenor |  -  |
**404** | There is no convenor in the database |  -  |

<a name="update1"></a>
# **update1**
> Convenor update1(convenor)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ConvenorRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ConvenorRestControllerApi apiInstance = new ConvenorRestControllerApi(defaultClient);
    Convenor convenor = new Convenor(); // Convenor | 
    try {
      Convenor result = apiInstance.update1(convenor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConvenorRestControllerApi#update1");
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
 **convenor** | [**Convenor**](Convenor.md)|  |

### Return type

[**Convenor**](Convenor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | There is no convenor against this ID |  -  |
**500** | Internal Server Error |  -  |
**200** | Successfully updated the convenor |  -  |

