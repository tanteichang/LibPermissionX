# PermissionX

一个 Android 权限申请库, 灵感来自《第一行代码 Android》

## 安装
- gradel 7.0
    在 settings.gradle 中添加 jitpack 仓库
```
  dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
  ```
    在项目依赖中添加

```
dependencies {
    ...
   implementation 'com.github.tanteichang:LibPermissionX:(insert latest version)'
}
```
接下来就可以愉快的使用了

## 使用
```kotlin
PermissionX.request(this, Manifest.permission.CALL_PHONE) {allGranted, deniedList ->
                if (allGranted) {
                    // do something you want
                } else {
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_LONG).show()
                }
            }
```