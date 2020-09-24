var jsonData = pm.response.json();

let choices = [];

var results = jsonData.results;

for (let i = 0; i < results.length; i++) {

    var vicinity = results[i].vicinity;
    var rating = results[i].rating;
    var bizName = results[i].name;

    console.info("vicinity:" + vicinity);
    console.info("rating:" + rating);
    console.info("bizName:" + bizName);

    choices.push({
        "name": bizName,
        "rating": rating,
        "vicinity": vicinity
    })

}

pm.environment.set("SEP_STR_CHOICES", JSON.stringify(choices));