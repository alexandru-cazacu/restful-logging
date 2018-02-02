# RESTful Logger

RESTful logger made with MySQL and a bunch of libraries. Database is not implemented, you will have to create a new one by yourself. 😥

## Table of contents

- [GET Logs](#get-logs)
- [GET Settings](#get-settings)
- [POST New log](#post-new-log)

## GET Logs

#### Description

Returns a JSON containin a list of logs. The list can be filtered using the following params:

- appId
- level

#### API call

`localhost:8080/api/logmessages?appId={appId}&level={severity level}`

#### Example

`localhost:8080/api/logmessages?appId=super-awesome-app&level=SEVERE`

#### Body

```json
[
    {
        "timestamp": "value",
        "cityId": "value",
        "message": "value",
        "level": "value"
    },
    {
        ...
    }
]
```

## GET Settings

#### Description

Get a JSON that contains a list of the logs that should be logged. It also contains a number that represents the interval in seconds that the client should wait before the next request.

#### API call

`localhost:8080/api/logmessages/settings`

#### Body

```json
{
  "loggableLevels": [
      "SEVERE",
      "WARNING"
      ],
  "newRequestIntervalInSeconds": 10
}
```

## POST Lew log

#### Description

Sends a new Log to the server.

#### API call

`localhost:8080/api/logmessages`

#### Body

```json
{
    "cityId": "value",
    "message": "value",
    "level": "value"
}
```
