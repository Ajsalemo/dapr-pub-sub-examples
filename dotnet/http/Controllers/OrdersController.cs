using Microsoft.AspNetCore.Mvc;

namespace http.Controllers;

[ApiController]
[Route("/orders")]
public class OrdersController : ControllerBase
{
    [HttpPost]
    public string Subscribe([FromBody] dynamic content)
    {
        string order = "Order recieved with information: " + content.ToString();
        Console.WriteLine(order);
        return order;
    }
}