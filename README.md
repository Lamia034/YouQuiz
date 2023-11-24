# YouQuiz
API d’une plateforme d’examens et de quiz avec spring boot
Diagramme de class : 
![alt text](https://github.com/Lamia034/YouQuiz/blob/main/conception/Untitled.vpd%20(2).png)

## API Request
GET http://localhost:8080/subjects

## API Response

```json
[
    {
        "subject_id": 1,
        "title": "Your Subject Title",
        "parent": null,
        "children": [
            {
                "subject_id": 2,
                "title": "philoosophyyy",
                "parent_id": 1
            },
            {
                "subject_id": 602,
                "title": "arabic",
                "parent_id": 1
            }
        ]
    },
    {
        "subject_id": 2,
        "title": "philoosophyyy",
        "parent": {
            "subject_id": 1,
            "title": "Your Subject Title",
            "parent": null,
            "children": [
                {
                    "subject_id": 2,
                    "title": "philoosophyyy",
                    "parent_id": 1
                },
                {
                    "subject_id": 602,
                    "title": "arabic",
                    "parent_id": 1
                }
            ]
        },
        "children": []
    },
    {
        "subject_id": 302,
        "title": "arabiccc ",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 352,
        "title": "french",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 353,
        "title": "french",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 402,
        "title": "french",
        "parent": null,
        "children": [
            {
                "subject_id": 603,
                "title": "spanish",
                "parent_id": 402
            }
        ]
    },
    {
        "subject_id": 403,
        "title": "french",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 405,
        "title": "french",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 452,
        "title": "arabic",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 453,
        "title": "arabic",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 502,
        "title": "arabic",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 503,
        "title": "arabic",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 552,
        "title": "arabic",
        "parent": null,
        "children": []
    },
    {
        "subject_id": 602,
        "title": "arabic",
        "parent": {
            "subject_id": 1,
            "title": "Your Subject Title",
            "parent": null,
            "children": [
                {
                    "subject_id": 2,
                    "title": "philoosophyyy",
                    "parent_id": 1
                },
                {
                    "subject_id": 602,
                    "title": "arabic",
                    "parent_id": 1
                }
            ]
        },
        "children": []
    },
    {
        "subject_id": 603,
        "title": "spanish",
        "parent": {
            "subject_id": 402,
            "title": "french",
            "parent": null,
            "children": [
                {
                    "subject_id": 603,
                    "title": "spanish",
                    "parent_id": 402
                }
            ]
        },
        "children": []
    }

]
```

## API Request
POST http://localhost:8080/subjects
Content-Type: application/json

{
  "title": "spanish",
  "parent_id": 402
}

## API Response
{
    "subject_id": 652,
    "title": "spanish",
    "parent_id": 402
}
