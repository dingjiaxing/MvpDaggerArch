## MvpDaggerArch
0. 简介：MvpDaggerArch是基于google官方推荐的MVP+dagger开发模式、同时集成了retrofit+rxJava2、greenDao、MMKV等，
设计的一套可用于中小型项目的完整解决方案，可用于android初学者学习架构、android开发者直接基于此架构进行开发。
1. 技术选型：MVP+dagger+retrofit+rxJava2
2. 开发模式：MVP+dagger
3. 网络请求：retrofit+rxJava2
4. 数据库：greenDao
5. 配置存储：MMKV（替代SharePreference）
6. 数据传递：EventBus
7. 日志打印：logger
8. 提高效率：butterknife

## 环境要求
1. Android Studio 3.4.1及以上

## 使用文档
1. [中文使用文档](https://blog.csdn.net/qq_23081779/article/details/96143754)

## 模块介绍
1. lib_http: 网络框架
2. core: 核心库模块
3. app：主业务模块

### MVP+dagger
#### 学习
1. [浅析Dagger2的使用]( https://www.cnblogs.com/all88/p/5788556.html)
2. [深入浅出Dagger2](从入门到爱不释手: https://www.jianshu.com/p/626b2087e2b1)
3. [谷歌官方demo](https://github.com/googlesamples/android-architecture/tree/todo-mvp/)
4. [Google官方MVP+Dagger2架构详解]( https://www.jianshu.com/p/01d3c014b0b1)
5. [MVP与MVP+Dagger2的使用及比较](https://blog.csdn.net/shoushow_yeping/article/details/71421627)
#### 注解说明
1. @Inject Inject主要有两个作用，一个是使用在构造函数上，通过标记构造函数让Dagger2来使用（Dagger2通过Inject标记可以在需要这个类实 例的时候来找到这个构造函数并把相关实例new出来）从而提供依赖，另一个作用就是标记在需要依赖的变量让Dagger2为其提供依赖。
2. @Provide 用Provide来标注一个方法，该方法可以在需要提供依赖时被调用，从而把预先提供好的对象当做依赖给标注了@Injection的变量赋值。provide主要用于标注Module里的方法
3. @Module 用Module标注的类是专门用来提供依赖的。有的人可能有些疑惑，看了上面的@Inject，需要在构造函数上标记才能提供依赖，那么如果我们需要提供 的类构造函数无法修改怎么办，比如一些jar包里的类，我们无法修改源码。这时候就需要使用Module了。Module可以给不能修改源码的类提供依 赖，当然，能用Inject标注的通过Module也可以提供依赖
4. @Component Component一般用来标注接口，被标注了Component的接口在编译时会产生相应的类的实例来作为提供依赖方和需要依赖方之间的桥梁，把相关依赖注入到其中。

#### 使用说明
1. 新增页面时，要先新增对应的activity、fragment、contract、module、presenter;
* activity：页面容器，一般不包含核心业务
* fragment：核心页面，View层的实现层，本架构采用重fragment轻activity的设计思想
* contract：定义View层和Presenter层的抽象层接口
* module：定义注解关系
* presenter：presenter层的实现
2. ActivityBindingModule中新增activity
3. ApiService中新增接口配置

#### 注意事项
1. AndroidApplication中com.soft863.ioms.di.DaggerAppComponent为运行期生成的，所以要先点击Build->Make Project才能编译成功；
2. 一定要注意注解，注解不对，运行时便会报一些奇怪的错误；

### retrofit+rxJava2
1. 网路框架：基于okhttp，采用单一职责原则，结合rxJava2对其进行封装
2. 测试api文档: https://www.wanandroid.com/blog/show/2

### greenDao
1. 源码地址：https://github.com/greenrobot/greenDAO
2. 使用解析：https://www.jianshu.com/p/53083f782ea2

### MMKV
1. 源码地址：https://github.com/Tencent/MMKV
2. 中文文档：https://github.com/Tencent/MMKV/blob/master/readme_cn.md
3. 介绍：MMKV 是基于 mmap 内存映射的 key-value 组件，底层序列化/反序列化使用 protobuf 实现，性能高，稳定性强。
从 2015 年中至今在微信上使用，其性能和稳定性经过了时间的验证。近期也已移植到 Android / macOS / Windows 平台，一并开源。
4. 本项目使用门面模式对其进行封装，可直接通过ConfigDataEngine类进行使用

### EventBus
1. 源码地址：https://github.com/greenrobot/EventBus


### logger
1. 源码地址：https://github.com/orhanobut/logger

## 设计模式
1. 单例
* DataRepository中使用了单例
2. 代理
* HttpDataSource、LocalDataSource、HttpDataSourceImpl、LocalDataSourceImpl、DataRepository使用到了代理模式，可以做到做最少的改变替换数据层引擎
3. 门面
* ConfigDataEngine使用到了门面模式，易修改和维护，后续方便修改为其他引擎


#### 参与贡献
1. 框架设计：丁家星
2. 网络框架贡献：DevinSun