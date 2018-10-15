# SuperDecoration
超强扩展性的Decoration

项目特点
* 支持水平和垂直创建分割线；
* 支持color、drawable、paint创建分割线；
* 支持不同position分割线样式可不同；
* 控制分割线是否显示；

##  APK下载
[Download](https://github.com/linuxjava/SuperDecoration/raw/master/apk/app-debug.apk)

## 使用
### 添加依赖
```xml
implementation 'xiao.free.decoration:SuperDecorationLib:0.2'
```
### Color

```xml
mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .size(1).margin(20, 20)
                .colorResId(R.color.colorAccent)
                .build());
```
### Drawable
```xml
mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
        .drawable(R.drawable.shape_divider)
        .build());
```
### Paint
```xml
Paint paint = new Paint();
paint.setStrokeWidth(5);
paint.setColor(Color.BLUE);
paint.setAntiAlias(true);
paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
        .paint(paint)
        .showLastDivider()
        .build());
```





