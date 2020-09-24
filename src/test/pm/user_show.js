var jsonData = pm.response.json();

var id_str = jsonData.id_str

pm.environment.set("SEP_ID_STR", id_str);