<?php

use App\Http\Controllers\OrderController;
use App\Http\Controllers\PublishController;
use App\Http\Controllers\SubscribeController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::post('/orders', [OrderController::class, 'order']);
Route::get('/api/pub', [PublishController::class, 'publish']);
Route::get('/dapr/subscribe', [SubscribeController::class, 'subscribe']);
