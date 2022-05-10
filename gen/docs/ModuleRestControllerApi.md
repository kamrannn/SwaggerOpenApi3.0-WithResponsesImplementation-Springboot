# ModuleRestControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](ModuleRestControllerApi.md#create) | **POST** /modules | 
[**createSessionInModule**](ModuleRestControllerApi.md#createSessionInModule) | **POST** /modules/{code}/sessions | 
[**delete**](ModuleRestControllerApi.md#delete) | **DELETE** /modules | 
[**deleteSessionFromAModule**](ModuleRestControllerApi.md#deleteSessionFromAModule) | **DELETE** /modules/{code}/sessions/{id} | 
[**getSessionFromAModule**](ModuleRestControllerApi.md#getSessionFromAModule) | **GET** /modules/{code}/sessions/{id} | 
[**list**](ModuleRestControllerApi.md#list) | **GET** /modules | 
[**modulesTaughtByConvenor**](ModuleRestControllerApi.md#modulesTaughtByConvenor) | **GET** /modules/{code}/sessions | 
[**update**](ModuleRestControllerApi.md#update) | **PUT** /modules | 
[**updateSessionInModule**](ModuleRestControllerApi.md#updateSessionInModule) | **PUT** /modules/{code}/sessions | 


<a name="create"></a>
# **create**
> Module create(module)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    Module module = new Module(); // Module | 
    try {
      Module result = apiInstance.create(module);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#create");
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
 **module** | [**Module**](Module.md)|  |

### Return type

[**Module**](Module.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createSessionInModule"></a>
# **createSessionInModule**
> List&lt;Session&gt; createSessionInModule(code, session)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    String code = "code_example"; // String | 
    Session session = new Session(); // Session | 
    try {
      List<Session> result = apiInstance.createSessionInModule(code, session);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#createSessionInModule");
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
 **code** | **String**|  |
 **session** | [**Session**](Session.md)|  |

### Return type

[**List&lt;Session&gt;**](Session.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="delete"></a>
# **delete**
> String delete(code)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    String code = "code_example"; // String | 
    try {
      String result = apiInstance.delete(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#delete");
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
 **code** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteSessionFromAModule"></a>
# **deleteSessionFromAModule**
> String deleteSessionFromAModule(code, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    String code = "code_example"; // String | 
    Long id = 56L; // Long | 
    try {
      String result = apiInstance.deleteSessionFromAModule(code, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#deleteSessionFromAModule");
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
 **code** | **String**|  |
 **id** | **Long**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getSessionFromAModule"></a>
# **getSessionFromAModule**
> Session getSessionFromAModule(code, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    String code = "code_example"; // String | 
    Long id = 56L; // Long | 
    try {
      Session result = apiInstance.getSessionFromAModule(code, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#getSessionFromAModule");
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
 **code** | **String**|  |
 **id** | **Long**|  |

### Return type

[**Session**](Session.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="list"></a>
# **list**
> List&lt;Module&gt; list()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    try {
      List<Module> result = apiInstance.list();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#list");
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

[**List&lt;Module&gt;**](Module.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="modulesTaughtByConvenor"></a>
# **modulesTaughtByConvenor**
> List&lt;Session&gt; modulesTaughtByConvenor(code)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    String code = "code_example"; // String | 
    try {
      List<Session> result = apiInstance.modulesTaughtByConvenor(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#modulesTaughtByConvenor");
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
 **code** | **String**|  |

### Return type

[**List&lt;Session&gt;**](Session.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="update"></a>
# **update**
> Module update(module)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    Module module = new Module(); // Module | 
    try {
      Module result = apiInstance.update(module);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#update");
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
 **module** | [**Module**](Module.md)|  |

### Return type

[**Module**](Module.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateSessionInModule"></a>
# **updateSessionInModule**
> List&lt;Session&gt; updateSessionInModule(code, session)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ModuleRestControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ModuleRestControllerApi apiInstance = new ModuleRestControllerApi(defaultClient);
    String code = "code_example"; // String | 
    Session session = new Session(); // Session | 
    try {
      List<Session> result = apiInstance.updateSessionInModule(code, session);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ModuleRestControllerApi#updateSessionInModule");
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
 **code** | **String**|  |
 **session** | [**Session**](Session.md)|  |

### Return type

[**List&lt;Session&gt;**](Session.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

