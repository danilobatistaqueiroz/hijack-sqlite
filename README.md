ionic start hijack blank --type=angular --capacitor --project-id=hijack-db --package-id=br.labs.hijackdb
# you need to use npm
npm init @capacitor/plugin@latest
```
  npx: installed 26 in 8.246s
  ✔ What should be the npm package of your plugin?
  … hijack-sqlite
  ✔ What directory should be used for your plugin?
  … hijack-sqlite
  ✔ What should be the Package ID for your plugin?

      Package IDs are unique identifiers used in apps and plugins. For plugins,
      they're used as a Java namespace. They must be in reverse domain name
      notation, generally representing a domain name that you or your company owns.

  … br.labs.hijack
  ✔ What should be the class name for your plugin?
  … ContactPlugin
  ✔ What is the repository URL for your plugin?
  … https://github.com/danilobatistaqueiroz/hijack-sqlite
  ✔ (optional) Who is the author of this plugin?
  … Danilo Batista de Queiroz
  ✔ What license should be used for your plugin?
  › MIT
  ✔ Enter a short description of plugin features.
  … copy the sqlite file from users/data folder from device to Documents folder and vice-versa
  Installing dependencies. Please wait...
```


# hijack-sqlite

Only copy the sqlite database from the data app filesystem to Documents folder

Go to your mobile setting -> apps -> select your app -> permissions -> storage -> select Allow managment of all files

In Android 11 android:requestLegacyExternalStorage="true" will simply be ignored, since it was an ad-hoc solution for Android < 11 to not break old apps. 
Now, you must use  
<uses-permission android:name="android.permission.MANAGE_EXTERNAL_STORAGE"/>



## Install

```bash
npm install hijack-sqlite
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`deleteDatabase(...)`](#deletedatabase)
* [`copyToDocuments(...)`](#copytodocuments)
* [`copyToUserData(...)`](#copytouserdata)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### deleteDatabase(...)

```typescript
deleteDatabase(database: { appID: string; name: string; }) => { result: boolean; }
```

| Param          | Type                                          |
| -------------- | --------------------------------------------- |
| **`database`** | <code>{ appID: string; name: string; }</code> |

**Returns:** <code>{ result: boolean; }</code>

--------------------


### copyToDocuments(...)

```typescript
copyToDocuments(database: { appID: string; name: string; }) => { result: boolean; }
```

| Param          | Type                                          |
| -------------- | --------------------------------------------- |
| **`database`** | <code>{ appID: string; name: string; }</code> |

**Returns:** <code>{ result: boolean; }</code>

--------------------


### copyToUserData(...)

```typescript
copyToUserData(database: { appID: string; name: string; }) => { result: boolean; }
```

| Param          | Type                                          |
| -------------- | --------------------------------------------- |
| **`database`** | <code>{ appID: string; name: string; }</code> |

**Returns:** <code>{ result: boolean; }</code>

--------------------

</docgen-api>
