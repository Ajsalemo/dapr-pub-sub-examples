using System.Text;
using System.Text.Json;
using Microsoft.AspNetCore.Mvc;
using Dapr.Client;

namespace sdk.Controllers;

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

        var order = new Order
        {
            OrderId = guid
        };

        var json = JsonSerializer.Serialize(order);
        var data = new StringContent(json, Encoding.UTF8, "application/json");

        var client = new DaprClientBuilder().Build();
        await client.PublishEventAsync("pubsub", "orders", data);
        string msg = "Order published with order id: " + guid;

        return msg;
    }
}

public class Order
{
    public string? OrderId { get; set; }
}