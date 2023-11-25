<?php

namespace App\Http\Controllers;

use Illuminate\Support\Str;

class PublishController extends Controller
{
    public function publish()
    {
        $id = (string) Str::uuid();
        $arr = array('orderId' => $id);
        $data = [$arr];

        $daprClient = \Dapr\Client\DaprClient::clientBuilder()->build();
        $daprClient->publishEvent('pubsub', 'orders', $data);

        return json_encode('Published order with id: ' . $id);
    }
}
