# Storeez Widget

## Install:

### 1. Add dependencies:

```
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.picasso:picasso:2.71828")
implementation("de.hdodenhof:circleimageview:3.1.0")
implementation("com.github.Emericanec:storeez-widget-android:1.0")
```

### 2. Add jitpack in `settings.gradle.kts` to `dependencyResolutionManagement.repositories` block:

```
maven { url = uri("https://jitpack.io") }
```

### 3. Add activity to your application in `AndroidManifest`:

```
<activity android:name="app.storeez.widget.StoreezWebViewActivity" />
```

### 4. Add widget to your view:

```
<app.storeez.widget.StoreezWidget
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        tools:listitem="@layout/storeez_story_item"
        android:paddingStart="8dp"
        android:paddingEnd="8dp"
        android:paddingTop="8dp"
        android:paddingBottom="8dp"
        app:widgetId="<YOUR WIDGET ID>"
        tools:ignore="MissingConstraints" />
```
