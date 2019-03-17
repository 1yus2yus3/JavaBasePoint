# JavaBasePoint
JVM结构：4部分

类装载器 ：在JVM启动时或在类运行时将需要的class加载到JVM中（javac把java文件转化class文件）

内存区（运行时数据区）：JVM运行时操作需要分配的内存区

执行引擎：负责执行class文件的字节码指令

本地接口：调用本地方法及返回结果


名称 | 特征 | 作用 | 配置 | 异常
------------ | ------------- | ------------ | ------------ | ------------
JAVA栈 | 线程私有、连续的内存空间  | 用于方法调用、存放局部变量表、操作栈、动态链接、方法出口 | -Xss | StackOverflowError OutOfMemoryError
JAVA堆 | 线程共有、生命周期与虚拟机相同 | 保存对象实例、数组 | -Xms -Xmx -Xmn | OutOfMemoryError
方法区（元空间） | 线程共有  | 存储类加载信息、常量、静态变量等 | -XX:PermSize -XX:MaxPermSize | OutOfMemoryError
程序计数器 | 线程私有、占用内存小  | 字节码行号 |   |  
本地方法栈 | 线程私有 | 使用native方法服务 |   | StackOverflowError OutOfMemoryError

### JVM参数详解
+ -Xss 参数：
    + 含义：每个线程分配的栈大小，决定java内函数调用的深度（deep of calling），主要存放方法内的局部变量，方法上的参数
    + 使用：-Xss1024k 栈大小默认1M
    + 优化：设置过小->栈溢出StackOverflowError,方法的调用需要压栈操作，这样容易导致递归深度过浅；但是相同物理机内存下，可创建的线程数
    更多，所以在高并发环境下，更小的值，可以有更高的并发；（3000-5000经验值）
    + 堆和栈的区别：
    如果栈内存没有可用的空间存储方法调用和局部变量，JVM会抛出java.lang.StackOverFlowError。
    而如果是堆内存没有可用的空间存储生成的对象，JVM会抛出java.lang.OutOfMemoryError。

+ -Xms 参数：
    + 含义：初始堆大小
    + 使用：-Xms
    
+ -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m
    
+ -XX:-UseBiasedLocking 参数
    + 含义：JVM 开启偏向锁
    + 使用：-UseBiasedLocking 停用 / +UseBiasedLocking 启用
    + 优化：单线程开启 无需在进行synchronized判断 多线程取消判段
    + 测试数据：3个线程测试（CyclicBarrier）
               多线程线程耗时 开启  -XX:+UseBiasedLocking：2204毫秒
               多线程线程耗时 停用  -XX:-UseBiasedLocking：2045毫秒
               单线程测试 
               单线程耗时 -XX:-UseBiasedLocking 停用 ：3745
               单线程耗时 -XX:+UseBiasedLocking 开启 ：3871
    
    
