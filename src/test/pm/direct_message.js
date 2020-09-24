var choices_str = pm.environment.get("SEP_STR_CHOICES")

var choices = JSON.parse(choices_str)

var messsage = "You should try " + choices[0].name

pm.environment.set("STR_message", messsage);