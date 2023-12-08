using System.Text;
using System.Text.Json;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;

namespace http.Controllers;

[ApiController]
[Route("/api/pub")]
public class PublishController : ControllerBase
{
    private readonly IHttpClientFactory _httpClientFactory;

    public PublishController(IHttpClientFactory httpClientFactory) =>
        _httpClientFactory = httpClientFactory;

    [HttpGet]
    public async Task<string> Publish()
    {
        string guid = Guid.NewGuid().ToString();

        JObject publishObj = new()
        {
            ["orderId"] = "pubsub",
        };

        JArray publishArray = new()
        {
            publishObj
        };

        var json = JsonSerializer.Serialize(publishArray);
        var data = new StringContent(json, Encoding.UTF8, "application/json");

        var httpClient = _httpClientFactory.CreateClient("daprClient");
        using var httpPostMessage = await httpClient.PostAsync("", data);

        string msg = "Order published with order id: " + guid;

        return msg;
    }
}