#  java内存分析  p146

https://www.bilibili.com/video/BV1Kb411W75N?p=146

## 

栈：存放局部变量
堆：存放new出来的变量，常见的也就是实例以及数组
指向：  引用类型在堆中开辟的内存空间的首地址，赋值给栈变量

```java
int[] arr = new int[]{1,2,3,4};
String[] arr1 = new String[4];
arr1[1] = "张学友"
```
