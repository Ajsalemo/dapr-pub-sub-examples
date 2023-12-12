using Microsoft.AspNetCore.Mvc;
using Dapr;

namespace http.Controllers;

[ApiController]
[Route("/dapr/subscribe")]
public class SubscribeController : ControllerBase
{
    [Topic("pubsub", "orders")]
    [HttpPost()]
    public string Subscribe([FromBody] dynamic content)
    {
        string order = "Order recieved with information: " + content.ToString();
        Console.WriteLine(order);
        return order;
    }
}