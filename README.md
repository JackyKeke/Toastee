# Toastee
东半球最好用的Toast库 ，可以自定义背景

### 背景颜色和文字颜色

```java
  public Toastee common(@ColorRes int tintColor, @ColorRes int textColor) 
```

### 位置

```java
 public Toastee gravity(int gravity)
```

### 是否需要图标

```java
 public Toastee withIcon(boolean b)
```

### 字体与大小

```java
 public Toastee currentTypeface(Typeface currentTypeface) 
 public Toastee textSize(int textSize) 
```

### 令人兴奋的功能——自定义Layout ！！！

``` kotlin
val toastLayout = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.toast_custom_layout, null)
Toastee.getInstance()
       .layout(toastLayout)
       .gravity(Gravity.BOTTOM)
       .custom(this)

```



