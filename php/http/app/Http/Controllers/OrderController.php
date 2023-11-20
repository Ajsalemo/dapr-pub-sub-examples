<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;

class OrderController extends Controller
{
    public function order(Request $request) {
        Log::info('Order received: ' . $request->getContent());

        $msg = 'dapr-pub-sub-examples-php-http';
        return response()->json($msg, 200);
    }
}
