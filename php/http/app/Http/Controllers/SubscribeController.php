<?php

namespace App\Http\Controllers;

class SubscribeController extends Controller
{
    public function subscribe() {
        $data = array(
            'topic' => 'orders',
            'route' => 'orders',
            'pubsubname' => 'pubsub'
        );

        $subscriptions = [$data];
        return $subscriptions;
    }
}
