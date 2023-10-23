from flask import Flask, jsonify, request
from uuid import uuid4
import requests, json

app = Flask(__name__)

@app.route("/")
def index():
    return jsonify({"msg": "dapr-pub-sub-examples-python-http"})


@app.route("/api/pub")
def publishController():
    id = str(uuid4())
    data = [{
        "orderId": id,
    }]

    requests.post("http://localhost:3500/v1.0/publish/pubsub/orders", json=data)

    return jsonify({"msg": f"Order published with order id: {id}"})


@app.route("/dapr/subscribe")
def subscribeController():
    subscriptions = [
        {
            "pubsubname": "pubsub",
            "topic": "orders",
            "route": "orders"
        }
    ]
    return jsonify(subscriptions)


@app.route("/orders", methods=["POST"])
def ordersController():
    print(f"Order recieved with information {request.json}")
    return json.dumps({'success':True}), 200, {'ContentType':'application/json'}