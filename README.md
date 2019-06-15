# wishlist-api-sdk-android
Librairie client de l'API pour Androïd

1 modèle = 1 classe + 1 API

## Avant exécution
- La machine sur laquelle est exécutée le back (Sails) doit être sur le même réseau que le client Androïd (tous les deux connectés à la même box)
- Récupérer l'adresse ipv4 de cette machine (exemple : 192.168.1.10)
- Dans le code du SDK Androïd, aller dans ApiConfig et assigner l'URL du serveur avec le port de Sails (par défaut 1337) : `public static final String BASE_URL = "http://192.168.1.10:1337";`
- Lancer le serveur Sails JS
- Lancer le client Androïd

## Méthodes
- `public List<T> findAll()`
- `public T findById(long id)`
- `public T create(T instance)`

### Exemples
```

CategoryApi categoryApi = new CategoryApi();

// FindAll et findById
try {
  List<Category> all = categoryApi.findAll();
  for (Category category : all) {
    Log.i("GET_TAG", "(ALL) category=" + category.toString());
  }

  Category cat1 = categoryApi.findById(1);
  Log.i("GET_TAG", "cat1="+cat1);

} catch (ExecutionException e) {
   e.printStackTrace();
} catch (InterruptedException e) {
  e.printStackTrace();
} catch (JSONException e) {
  e.printStackTrace();
}

// Create

Category category = new Category();
category.name = "jardinage";
try {
  Category storedCategory = categoryApi.create(category);
  Log.i("POST_TAG", "Stored category = " + storedCategory);
} catch (UnsupportedEncodingException e) {
  e.printStackTrace();
} catch (ExecutionException e) {
  e.printStackTrace();
} catch (InterruptedException e) {
  e.printStackTrace();
} catch (JSONException e) {
  e.printStackTrace();
}
```

## Authentification
```
AuthenticationApi authApi = new AuthenticationApi();

try {
    LoginResponse res = authApi.login("toto2@yopmail.com", "toto");
    Log.i(GET_TAG, "res login="+res);
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
} catch (ExecutionException e) {
    e.printStackTrace();
} catch (InterruptedException e) {
    e.printStackTrace();
} catch (JSONException e) {
    e.printStackTrace();
}
```

`res login=LoginResponse{status=200, message='Login Succesful', user=UserLoginResponse{email='toto2@yopmail.com', id=4, token='eyJhbG...`}}
