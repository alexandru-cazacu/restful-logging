# RESTful Logger

RESTful logger made with MySQL and a bunch of libraries. Database is not implemented, you will have to create a new one by yourself. 😥

## Table of contents

- [GET Logs](#get-logs)
- [GET Settings](#get-settings)
- [POST New log](#post-new-log)

## GET Logs

#### Description

You can get all logs in a JSON format.

#### API call

localhost:8080/api/logmessages?appId={appId}&level={severity level}

#### Example

localhost:8080/api/logmessages?appId=super-awesome-app&level=SEVERE

#### Body

```json
[
    {
        timestamp: "value",
        cityId: "value",
        message: "value",
        level: "value"
    },
    {
        ...
    }
]
```

## GET Settings

#### Description

You can get settings of loggable levels and for the next request interval  in a JSON format.

#### API call

localhost:8080/api/logmessages/settings

#### Example

localhost:8080/api/logmessages/settings

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

You can send a new log.

#### API call

localhost:8080/api/logmessages

#### Example

localhost:8080/api/logmessages

#### Body

```json
{
    cityId: "value",
    message: "value",
    level: "value"
}
```
