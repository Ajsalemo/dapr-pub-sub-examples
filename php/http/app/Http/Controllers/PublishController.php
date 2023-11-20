<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\Http;
use Illuminate\Support\Str;

class PublishController extends Controller
{
    public function publish()
    {
        $id = (string) Str::uuid();
        $arr = array('orderId' => $id);
        $data = [$arr];
        
        Http::post('http://localhost:3500/v1.0/publish/pubsub/orders', $data);

        return json_encode('Published order with id: ' . $id);
    }
}
