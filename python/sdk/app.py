from flask import Flask, jsonify, request
from uuid import uuid4
from dapr.clients import DaprClient
import json

app = Flask(__name__)
d = DaprClient()

@app.route("/")
def index():
    return jsonify({"msg": "dapr-pub-sub-examples-python-http"})


@app.route("/api/pub")
def publishController():
    id = str(uuid4())
    data = [{
        "orderId": id,
    }]

    d.publish_event(pubsub_name="pubsub", topic_name="orders", data=f"{data}")

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