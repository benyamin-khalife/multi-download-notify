# show multi notify for download file in android

Copy and add myNotify class to Activity or Service

**build new notify**
``` java
myNotify.build("Title","text",notifyID,new Intent(this,MainAppActivity.class),Color.BLUE);
```

**update Progress**
``` java
myNotify.update(notifyID,progress,downloadSpeed);
```
**after completed download or Error to download**
``` java
// example for completed download
myNotify.completed(notifyID,"Title","text",new Intent(context,MainAppActivity.class),Color.BLUE);

// example for Error or ... 
myNotify.completed(notifyID,"Title","network access denied",new Intent(context,MainAppActivity.class),Color.RED);
```
