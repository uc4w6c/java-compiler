```:Test.java
package lang.javactest;

public class Test {
  public static void main(String... args) {
    String test = "Hello " + "World!";
    System.out.println(test);
  }
}
```

---
```:Test.class
$ hexdump Test.class
0000000 ca fe ba be 00 00 00 3c 00 24 0a 00 02 00 03 07
0000010 00 04 0c 00 05 00 06 01 00 10 6a 61 76 61 2f 6c
0000020 61 6e 67 2f 4f 62 6a 65 63 74 01 00 06 3c 69 6e
0000030 69 74 3e 01 00 03 28 29 56 08 00 08 01 00 0c 48
0000040 65 6c 6c 6f 20 57 6f 72 6c 64 21 09 00 0a 00 0b
0000050 07 00 0c 0c 00 0d 00 0e 01 00 10 6a 61 76 61 2f
0000060 6c 61 6e 67 2f 53 79 73 74 65 6d 01 00 03 6f 75
0000070 74 01 00 15 4c 6a 61 76 61 2f 69 6f 2f 50 72 69
0000080 6e 74 53 74 72 65 61 6d 3b 0a 00 10 00 11 07 00
0000090 12 0c 00 13 00 14 01 00 13 6a 61 76 61 2f 69 6f
00000a0 2f 50 72 69 6e 74 53 74 72 65 61 6d 01 00 07 70
00000b0 72 69 6e 74 6c 6e 01 00 15 28 4c 6a 61 76 61 2f
00000c0 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 29 56 07 00
00000d0 16 01 00 13 6c 61 6e 67 2f 6a 61 76 61 63 74 65
00000e0 73 74 2f 54 65 73 74 01 00 04 43 6f 64 65 01 00
00000f0 0f 4c 69 6e 65 4e 75 6d 62 65 72 54 61 62 6c 65
0000100 01 00 12 4c 6f 63 61 6c 56 61 72 69 61 62 6c 65
0000110 54 61 62 6c 65 01 00 04 74 68 69 73 01 00 15 4c
0000120 6c 61 6e 67 2f 6a 61 76 61 63 74 65 73 74 2f 54
0000130 65 73 74 3b 01 00 04 6d 61 69 6e 01 00 16 28 5b
0000140 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e
0000150 67 3b 29 56 01 00 04 61 72 67 73 01 00 13 5b 4c
0000160 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67
0000170 3b 01 00 04 74 65 73 74 01 00 12 4c 6a 61 76 61
0000180 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 01 00 0a
0000190 53 6f 75 72 63 65 46 69 6c 65 01 00 09 54 65 73
00001a0 74 2e 6a 61 76 61 00 21 00 15 00 02 00 00 00 00
00001b0 00 02 00 01 00 05 00 06 00 01 00 17 00 00 00 2f
00001c0 00 01 00 01 00 00 00 05 2a b7 00 01 b1 00 00 00
00001d0 02 00 18 00 00 00 06 00 01 00 00 00 03 00 19 00
00001e0 00 00 0c 00 01 00 00 00 05 00 1a 00 1b 00 00 00
00001f0 89 00 1c 00 1d 00 01 00 17 00 00 00 47 00 02 00
0000200 02 00 00 00 0b 12 07 4c b2 00 09 2b b6 00 0f b1
0000210 00 00 00 02 00 18 00 00 00 0e 00 03 00 00 00 05
0000220 00 03 00 06 00 0a 00 07 00 19 00 00 00 16 00 02
0000230 00 00 00 0b 00 1e 00 1f 00 00 00 03 00 08 00 20
0000240 00 21 00 01 00 01 00 22 00 00 00 02 00 23      
000024e
```

---
## リンク
https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-4.html

### magic
0000000行目

ca fe ba be : 固定マジックナンバー

### minor_version
0000000行目

00 00

### major_version
0000000行目

00 3c
10進数で60のため version.16

### constant_pool_count
0000000行目

00 24
constant_pool_count 10進数で36個

### constant_pool
0000000行目〜00001a0行目

#### 1つ目
0000000行目

0a
10進数で10 - CONSTANT_Methodref

00 02
class_index: 2つ目のインデックスを参照

00 03
name_and_type_index: 3つ目のインデックスを参照 

#### 2つ目
0000000行目, 0000010行目
07
10進数で7 - CONSTANT_Class

00 04
name_index: 4つ目のインデックスを参照

#### 3つ目
0000010行目
0c
10進数で12 - CONSTANT_NameAndType

00 05
name_index: 5つ目のインデックスを参照

00 06
descriptor_index: 6つ目のインデックスを参照

#### 4つ目
0000010, 0000020行目
01
10進数で1 - CONSTANT_Utf8

00 10
10進数で16 - length
次のValueが16バイトあることを表す

6a 61 76 61 2f 6c 61 6e 67 2f 4f 62 6a 65 63 74
(6a6176612f6c616e672f4f626a656374)
上記16進数をUTF-8でデコードすると
java/lang/Object

#### 5つ目
0000020, 0000030行目
01
10進数で1 - CONSTANT_Utf8

00 06
10進数で6 - length
次のValueが6バイトあることを表す

3c 69 6e 69 74 3e
(3c696e69743e)
上記16進数をUTF-8でデコードすると
<init>

#### 6つ目
0000030行目
01
10進数で1 - CONSTANT_Utf8

00 03
10進数で3 - length
次のValueが3バイトあることを表す

28 29 56
(282956)
上記16進数をUTF-8でデコードすると
()V

#### 7つ目
0000030行目
08
10進数で8 - CONSTANT_String

00 08
10進数で8 - string_index
8つ目のインデックスを参照

#### 8つ目
0000030, 0000040行目
01
10進数で1 - CONSTANT_Utf8

00 0c
10進数で12 - length
次のValueが12バイトあることを表す

48 65 6c 6c 6f 20 57 6f 72 6c 64 21
(48656c6c6f20576f726c6421)
上記16進数をUTF-8でデコードすると
Hello World!

#### 9つ目
0000040行目
09
10進数で9 - CONSTANT_Fieldref

00 0a
class_index: 10つ目のインデックスを参照

00 0b
name_and_type_index: 11つ目のインデックスを参照

#### 10つ目
0000050行目
07
10進数で7 - CONSTANT_Class

00 0c
name_index: 12つ目のインデックスを参照

#### 11つ目
0000050行目
0c
10進数で12 - CONSTANT_NameAndType

00 0d
name_index: 13つ目のインデックスを参照

00 0e
descriptor_index: 14つ目のインデックスを参照

#### 12つ目
0000050, 0000060行目
01
10進数で1 - CONSTANT_Utf8

00 10
10進数で16 - length
次のValueが16バイトあることを表す

6a 61 76 61 2f 6c 61 6e 67 2f 53 79 73 74 65 6d
(6a6176612f6c616e672f53797374656d)
上記16進数をUTF-8でデコードすると
java/lang/System

#### 13つ目
0000060, 0000070行目
01
10進数で1 - CONSTANT_Utf8

00 03
10進数で3 - length
次のValueが3バイトあることを表す

6f 75 74
(6f7574)
上記16進数をUTF-8でデコードすると
out


#### 14つ目
0000070, 0000080行目
01
10進数で1 - CONSTANT_Utf8

00 15
10進数で21 - length
次のValueが21バイトあることを表す

4c 6a 61 76 61 2f 69 6f 2f 50 72 69 6e 74 53 74 72 65 61 6d 3b
(4c6a6176612f696f2f5072696e7453747265616d3b)
上記16進数をUTF-8でデコードすると
Ljava/io/PrintStream;

#### 15つ目
0000080行目
0a
10進数で10 - CONSTANT_Methodref

00 10
class_index: 16つ目のインデックスを参照

00 11
name_and_type_index: 17つ目のインデックスを参照

#### 16つ目
0000080, 0000090行目
07
10進数で7 - CONSTANT_Class

00 12
name_index: 18つ目のインデックスを参照

#### 17つ目
0000090行目
0c
10進数で12 - CONSTANT_NameAndType

00 13
name_index: 19つ目のインデックスを参照

00 14
descriptor_index: 20つ目のインデックスを参照

#### 18つ目
0000090, 00000a0行目
01
10進数で1 - CONSTANT_Utf8

00 13
10進数で19 - length
次のValueが19バイトあることを表す

6a 61 76 61 2f 69 6f 2f 50 72 69 6e 74 53 74 72 65 61 6d
(6a6176612f696f2f5072696e7453747265616d)
上記16進数をUTF-8でデコードすると
java/io/PrintStream

#### 19つ目
00000a0, 00000b0行目
01
10進数で1 - CONSTANT_Utf8

00 07
10進数で7 - length
次のValueが7バイトあることを表す

70 72 69 6e 74 6c 6e
(7072696e746c6e)
上記16進数をUTF-8でデコードすると
println

#### 20つ目
00000b0, 00000c0行目
01
10進数で1 - CONSTANT_Utf8

00 15
10進数で21 - length
次のValueが7バイトあることを表す

28 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 29 56
(284c6a6176612f6c616e672f537472696e673b2956)
上記16進数をUTF-8でデコードすると
(Ljava/lang/String;)V

#### 21つ目
00000c0, 00000d0行目
07
10進数で7 - CONSTANT_Class

00 16
name_index: 22つ目のインデックスを参照

#### 22つ目
00000d0, 00000e0行目
01
10進数で1 - CONSTANT_Utf8

00 13
10進数で19 - length
次のValueが19バイトあることを表す

6c 61 6e 67 2f 6a 61 76 61 63 74 65 73 74 2f 54 65 73 74
(6c616e672f6a61766163746573742f54657374)
上記16進数をUTF-8でデコードすると
lang/javactest/Test

#### 23つ目
00000e0行目
01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

43 6f 64 65
(436f6465)
上記16進数をUTF-8でデコードすると
Code

#### 24つ目
00000e0, 00000f0行目
01
10進数で1 - CONSTANT_Utf8

0f
10進数で15 - length
次のValueが15バイトあることを表す

4c 69 6e 65 4e 75 6d 62 65 72 54 61 62 6c 65
(4c696e654e756d6265725461626c65)
上記16進数をUTF-8でデコードすると
LineNumberTable

#### 25つ目
0000100, 0000110行目
01
10進数で1 - CONSTANT_Utf8

00 12
10進数で18 - length
次のValueが18バイトあることを表す

4c 6f 63 61 6c 56 61 72 69 61 62 6c 65 54 61 62 6c 65
上記16進数をUTF-8でデコードすると
LocalVariableTable

#### 26つ目
0000110行目
01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

74 68 69 73
上記16進数をUTF-8でデコードすると
this

#### 27つ目
0000110, 0000120, 0000130行目
01
10進数で1 - CONSTANT_Utf8

00 15
10進数で21 - length
次のValueが21バイトあることを表す

4c 6c 61 6e 67 2f 6a 61 76 61 63 74 65 73 74 2f 54 65 73 74 3b
(4c6c616e672f6a61766163746573742f546573743b)
上記16進数をUTF-8でデコードすると
Llang/javactest/Test;

#### 28つ目
0000130行目

01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

6d 61 69 6e
上記16進数をUTF-8でデコードすると
main

#### 29つ目
0000130, 0000140, 0000150行目

01
10進数で1 - CONSTANT_Utf8

00 16
10進数で22 - length
次のValueが22バイトあることを表す

28 5b 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 29 56
(285b4c6a6176612f6c616e672f537472696e673b2956)
上記16進数をUTF-8でデコードすると
([Ljava/lang/String;)V

#### 30つ目
0000150行目

01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

61 72 67 73
上記16進数をUTF-8でデコードすると
args

#### 31つ目
0000150, 0000160, 0000170行目

01
10進数で1 - CONSTANT_Utf8

00 13
10進数で19 - length
次のValueが19バイトあることを表す

5b 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b
上記16進数をUTF-8でデコードすると
[Ljava/lang/String;

#### 32つ目
0000170行目

01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

74 65 73 74
上記16進数をUTF-8でデコードすると
test

#### 33つ目
0000170, 0000180行目

01
10進数で1 - CONSTANT_Utf8

00 12
10進数で18 - length
次のValueが18バイトあることを表す

4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b
上記16進数をUTF-8でデコードすると
Ljava/lang/String;

#### 34つ目
0000180, 0000190行目

01
10進数で1 - CONSTANT_Utf8

00 0a
10進数で10 - length
次のValueが10バイトあることを表す

53 6f 75 72 63 65 46 69 6c 65
(536f7572636546696c65)
上記16進数をUTF-8でデコードすると
SourceFile

#### 35つ目
0000190行目

01
10進数で1 - CONSTANT_Utf8

00 09
10進数で9 - length
次のValueが9バイトあることを表す

54 65 73 74 2e 6a 61 76 61
(546573742e6a617661)
上記16進数をUTF-8でデコードすると
Test.java

### access_flags
00001a0行目
00 21
ACC_PUBLIC(0x0001) +
ACC_SUPER(0x0020)

### this_class
00001a0行目
00 15
21つ目のコンスタントプールを参照

### super_class
00001a0行目
00 02
2つ目のコンスタントプールを参照

### interfaces_count
00001a0行目
00 00

インターフェースは0つ

### interfaces
なし

### fields_count
00001a0行目
00 00

フィールドは0つ

### methods_count
00001b0行目
00 02

メソッドは2つ

### methods
00001b0行目〜

#### 1つ目
00001b0

00 01
access_flags
ACC_PUBLIC(0x0001)

00 05
name_index: 5つ目のコンスタントプールを参照
<init>

00 06   
descriptor_index: 6つ目のコンスタントプールを参照
()V

00 01
attributes_count: 1つのattribute

##### attribute_info
00001b0, 00001c0行目

00 17
attribute_name_index: 23つ目のコンスタントプールを参照
Code

00 00 00 2f
attribute_length: 47

attribute_name_indexがCodeのため
Code_attributeを見る

00 01 (ここから00001c0)
max_stack: 1つ

00 01
max_locals: ローカル変数の数1つ

00 00 00 05
code_length: 5つ

###### code
00001c0

2a: aload_0
b7: invokespecial
 00 01: 1つ目のコンスタントプールを参照
b1: return

00 00
excep```:Test.java
package lang.javactest;

public class Test {
public static void main(String... args) {
String test = "Hello " + "World!";
System.out.println(test);
}
}
```

---
```:Test.class
$ hexdump Test.class
0000000 ca fe ba be 00 00 00 3c 00 24 0a 00 02 00 03 07
0000010 00 04 0c 00 05 00 06 01 00 10 6a 61 76 61 2f 6c
0000020 61 6e 67 2f 4f 62 6a 65 63 74 01 00 06 3c 69 6e
0000030 69 74 3e 01 00 03 28 29 56 08 00 08 01 00 0c 48
0000040 65 6c 6c 6f 20 57 6f 72 6c 64 21 09 00 0a 00 0b
0000050 07 00 0c 0c 00 0d 00 0e 01 00 10 6a 61 76 61 2f
0000060 6c 61 6e 67 2f 53 79 73 74 65 6d 01 00 03 6f 75
0000070 74 01 00 15 4c 6a 61 76 61 2f 69 6f 2f 50 72 69
0000080 6e 74 53 74 72 65 61 6d 3b 0a 00 10 00 11 07 00
0000090 12 0c 00 13 00 14 01 00 13 6a 61 76 61 2f 69 6f
00000a0 2f 50 72 69 6e 74 53 74 72 65 61 6d 01 00 07 70
00000b0 72 69 6e 74 6c 6e 01 00 15 28 4c 6a 61 76 61 2f
00000c0 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 29 56 07 00
00000d0 16 01 00 13 6c 61 6e 67 2f 6a 61 76 61 63 74 65
00000e0 73 74 2f 54 65 73 74 01 00 04 43 6f 64 65 01 00
00000f0 0f 4c 69 6e 65 4e 75 6d 62 65 72 54 61 62 6c 65
0000100 01 00 12 4c 6f 63 61 6c 56 61 72 69 61 62 6c 65
0000110 54 61 62 6c 65 01 00 04 74 68 69 73 01 00 15 4c
0000120 6c 61 6e 67 2f 6a 61 76 61 63 74 65 73 74 2f 54
0000130 65 73 74 3b 01 00 04 6d 61 69 6e 01 00 16 28 5b
0000140 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e
0000150 67 3b 29 56 01 00 04 61 72 67 73 01 00 13 5b 4c
0000160 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67
0000170 3b 01 00 04 74 65 73 74 01 00 12 4c 6a 61 76 61
0000180 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 01 00 0a
0000190 53 6f 75 72 63 65 46 69 6c 65 01 00 09 54 65 73
00001a0 74 2e 6a 61 76 61 00 21 00 15 00 02 00 00 00 00
00001b0 00 02 00 01 00 05 00 06 00 01 00 17 00 00 00 2f
00001c0 00 01 00 01 00 00 00 05 2a b7 00 01 b1 00 00 00
00001d0 02 00 18 00 00 00 06 00 01 00 00 00 03 00 19 00
00001e0 00 00 0c 00 01 00 00 00 05 00 1a 00 1b 00 00 00
00001f0 89 00 1c 00 1d 00 01 00 17 00 00 00 47 00 02 00
0000200 02 00 00 00 0b 12 07 4c b2 00 09 2b b6 00 0f b1
0000210 00 00 00 02 00 18 00 00 00 0e 00 03 00 00 00 05
0000220 00 03 00 06 00 0a 00 07 00 19 00 00 00 16 00 02
0000230 00 00 00 0b 00 1e 00 1f 00 00 00 03 00 08 00 20
0000240 00 21 00 01 00 01 00 22 00 00 00 02 00 23      
000024e
```

---
## リンク
https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-4.html

### magic
0000000行目

ca fe ba be : 固定マジックナンバー

### minor_version
0000000行目

00 00

### major_version
0000000行目

00 3c
10進数で60のため version.16

### constant_pool_count
0000000行目

00 24
constant_pool_count 10進数で36個

### constant_pool
0000000行目〜00001a0行目

#### 1つ目
0000000行目

0a
10進数で10 - CONSTANT_Methodref

00 02
class_index: 2つ目のインデックスを参照

00 03
name_and_type_index: 3つ目のインデックスを参照

#### 2つ目
0000000行目, 0000010行目
07
10進数で7 - CONSTANT_Class

00 04
name_index: 4つ目のインデックスを参照

#### 3つ目
0000010行目
0c
10進数で12 - CONSTANT_NameAndType

00 05
name_index: 5つ目のインデックスを参照

00 06
descriptor_index: 6つ目のインデックスを参照

#### 4つ目
0000010, 0000020行目
01
10進数で1 - CONSTANT_Utf8

00 10
10進数で16 - length
次のValueが16バイトあることを表す

6a 61 76 61 2f 6c 61 6e 67 2f 4f 62 6a 65 63 74
(6a6176612f6c616e672f4f626a656374)
上記16進数をUTF-8でデコードすると
java/lang/Object

#### 5つ目
0000020, 0000030行目
01
10進数で1 - CONSTANT_Utf8

00 06
10進数で6 - length
次のValueが6バイトあることを表す

3c 69 6e 69 74 3e
(3c696e69743e)
上記16進数をUTF-8でデコードすると
<init>

#### 6つ目
0000030行目
01
10進数で1 - CONSTANT_Utf8

00 03
10進数で3 - length
次のValueが3バイトあることを表す

28 29 56
(282956)
上記16進数をUTF-8でデコードすると
()V

#### 7つ目
0000030行目
08
10進数で8 - CONSTANT_String

00 08
10進数で8 - string_index
8つ目のインデックスを参照

#### 8つ目
0000030, 0000040行目
01
10進数で1 - CONSTANT_Utf8

00 0c
10進数で12 - length
次のValueが12バイトあることを表す

48 65 6c 6c 6f 20 57 6f 72 6c 64 21
(48656c6c6f20576f726c6421)
上記16進数をUTF-8でデコードすると
Hello World!

#### 9つ目
0000040行目
09
10進数で9 - CONSTANT_Fieldref

00 0a
class_index: 10つ目のインデックスを参照

00 0b
name_and_type_index: 11つ目のインデックスを参照

#### 10つ目
0000050行目
07
10進数で7 - CONSTANT_Class

00 0c
name_index: 12つ目のインデックスを参照

#### 11つ目
0000050行目
0c
10進数で12 - CONSTANT_NameAndType

00 0d
name_index: 13つ目のインデックスを参照

00 0e
descriptor_index: 14つ目のインデックスを参照

#### 12つ目
0000050, 0000060行目
01
10進数で1 - CONSTANT_Utf8

00 10
10進数で16 - length
次のValueが16バイトあることを表す

6a 61 76 61 2f 6c 61 6e 67 2f 53 79 73 74 65 6d
(6a6176612f6c616e672f53797374656d)
上記16進数をUTF-8でデコードすると
java/lang/System

#### 13つ目
0000060, 0000070行目
01
10進数で1 - CONSTANT_Utf8

00 03
10進数で3 - length
次のValueが3バイトあることを表す

6f 75 74
(6f7574)
上記16進数をUTF-8でデコードすると
out


#### 14つ目
0000070, 0000080行目
01
10進数で1 - CONSTANT_Utf8

00 15
10進数で21 - length
次のValueが21バイトあることを表す

4c 6a 61 76 61 2f 69 6f 2f 50 72 69 6e 74 53 74 72 65 61 6d 3b
(4c6a6176612f696f2f5072696e7453747265616d3b)
上記16進数をUTF-8でデコードすると
Ljava/io/PrintStream;

#### 15つ目
0000080行目
0a
10進数で10 - CONSTANT_Methodref

00 10
class_index: 16つ目のインデックスを参照

00 11
name_and_type_index: 17つ目のインデックスを参照

#### 16つ目
0000080, 0000090行目
07
10進数で7 - CONSTANT_Class

00 12
name_index: 18つ目のインデックスを参照

#### 17つ目
0000090行目
0c
10進数で12 - CONSTANT_NameAndType

00 13
name_index: 19つ目のインデックスを参照

00 14
descriptor_index: 20つ目のインデックスを参照

#### 18つ目
0000090, 00000a0行目
01
10進数で1 - CONSTANT_Utf8

00 13
10進数で19 - length
次のValueが19バイトあることを表す

6a 61 76 61 2f 69 6f 2f 50 72 69 6e 74 53 74 72 65 61 6d
(6a6176612f696f2f5072696e7453747265616d)
上記16進数をUTF-8でデコードすると
java/io/PrintStream

#### 19つ目
00000a0, 00000b0行目
01
10進数で1 - CONSTANT_Utf8

00 07
10進数で7 - length
次のValueが7バイトあることを表す

70 72 69 6e 74 6c 6e
(7072696e746c6e)
上記16進数をUTF-8でデコードすると
println

#### 20つ目
00000b0, 00000c0行目
01
10進数で1 - CONSTANT_Utf8

00 15
10進数で21 - length
次のValueが7バイトあることを表す

28 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 29 56
(284c6a6176612f6c616e672f537472696e673b2956)
上記16進数をUTF-8でデコードすると
(Ljava/lang/String;)V

#### 21つ目
00000c0, 00000d0行目
07
10進数で7 - CONSTANT_Class

00 16
name_index: 22つ目のインデックスを参照

#### 22つ目
00000d0, 00000e0行目
01
10進数で1 - CONSTANT_Utf8

00 13
10進数で19 - length
次のValueが19バイトあることを表す

6c 61 6e 67 2f 6a 61 76 61 63 74 65 73 74 2f 54 65 73 74
(6c616e672f6a61766163746573742f54657374)
上記16進数をUTF-8でデコードすると
lang/javactest/Test

#### 23つ目
00000e0行目
01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

43 6f 64 65
(436f6465)
上記16進数をUTF-8でデコードすると
Code

#### 24つ目
00000e0, 00000f0行目
01
10進数で1 - CONSTANT_Utf8

0f
10進数で15 - length
次のValueが15バイトあることを表す

4c 69 6e 65 4e 75 6d 62 65 72 54 61 62 6c 65
(4c696e654e756d6265725461626c65)
上記16進数をUTF-8でデコードすると
LineNumberTable

#### 25つ目
0000100, 0000110行目
01
10進数で1 - CONSTANT_Utf8

00 12
10進数で18 - length
次のValueが18バイトあることを表す

4c 6f 63 61 6c 56 61 72 69 61 62 6c 65 54 61 62 6c 65
上記16進数をUTF-8でデコードすると
LocalVariableTable

#### 26つ目
0000110行目
01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

74 68 69 73
上記16進数をUTF-8でデコードすると
this

#### 27つ目
0000110, 0000120, 0000130行目
01
10進数で1 - CONSTANT_Utf8

00 15
10進数で21 - length
次のValueが21バイトあることを表す

4c 6c 61 6e 67 2f 6a 61 76 61 63 74 65 73 74 2f 54 65 73 74 3b
(4c6c616e672f6a61766163746573742f546573743b)
上記16進数をUTF-8でデコードすると
Llang/javactest/Test;

#### 28つ目
0000130行目

01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

6d 61 69 6e
上記16進数をUTF-8でデコードすると
main

#### 29つ目
0000130, 0000140, 0000150行目

01
10進数で1 - CONSTANT_Utf8

00 16
10進数で22 - length
次のValueが22バイトあることを表す

28 5b 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b 29 56
(285b4c6a6176612f6c616e672f537472696e673b2956)
上記16進数をUTF-8でデコードすると
([Ljava/lang/String;)V

#### 30つ目
0000150行目

01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

61 72 67 73
上記16進数をUTF-8でデコードすると
args

#### 31つ目
0000150, 0000160, 0000170行目

01
10進数で1 - CONSTANT_Utf8

00 13
10進数で19 - length
次のValueが19バイトあることを表す

5b 4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b
上記16進数をUTF-8でデコードすると
[Ljava/lang/String;

#### 32つ目
0000170行目

01
10進数で1 - CONSTANT_Utf8

00 04
10進数で4 - length
次のValueが4バイトあることを表す

74 65 73 74
上記16進数をUTF-8でデコードすると
test

#### 33つ目
0000170, 0000180行目

01
10進数で1 - CONSTANT_Utf8

00 12
10進数で18 - length
次のValueが18バイトあることを表す

4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b
上記16進数をUTF-8でデコードすると
Ljava/lang/String;

#### 34つ目
0000180, 0000190行目

01
10進数で1 - CONSTANT_Utf8

00 0a
10進数で10 - length
次のValueが10バイトあることを表す

53 6f 75 72 63 65 46 69 6c 65
(536f7572636546696c65)
上記16進数をUTF-8でデコードすると
SourceFile

#### 35つ目
0000190行目

01
10進数で1 - CONSTANT_Utf8

00 09
10進数で9 - length
次のValueが9バイトあることを表す

54 65 73 74 2e 6a 61 76 61
(546573742e6a617661)
上記16進数をUTF-8でデコードすると
Test.java

### access_flags
00001a0行目
00 21
ACC_PUBLIC(0x0001) +
ACC_SUPER(0x0020)

### this_class
00001a0行目
00 15
21つ目のコンスタントプールを参照

### super_class
00001a0行目
00 02
2つ目のコンスタントプールを参照

### interfaces_count
00001a0行目
00 00

インターフェースは0つ

### interfaces
なし

### fields_count
00001a0行目
00 00

フィールドは0つ

### methods_count
00001b0行目
00 02

メソッドは2つ

### methods
00001b0行目〜

#### 1つ目
00001b0〜00001d0行目

00 01
access_flags
ACC_PUBLIC(0x0001)

00 05
name_index: 5つ目のコンスタントプールを参照
<init>

00 06   
descriptor_index: 6つ目のコンスタントプールを参照
()V

00 01
attributes_count: 1つのattribute

##### attribute_info
00001b0, 00001c0行目

00 17
attribute_name_index: 23つ目のコンスタントプールを参照
Code

00 00 00 2f
attribute_length: 47

attribute_name_indexがCodeのため
Code_attributeを見る

00 01 (ここから00001c0)
max_stack: 1つ

00 01
max_locals: ローカル変数の数1つ

00 00 00 05
code_length: 5つ

###### code
00001c0

2a: aload_0
b7: invokespecial
00 01: 1つ目のコンスタントプールを参照
b1: return

00 00
exception_table_length

00 02
attributes_count

###### attributes
00001d0行目

####### attribute1つ目

00 18
attribute_name_index: 24つ目のコンスタントプールを参照
LineNumberTable

00 00 00 06
attribute_length: 6つ

attribute_name_indexがLineNumberTableのため
4.7.12. The LineNumberTable Attributeを参照

00 01
line_number_table_length

{
00 00
start_pc

00 03
line_number
}

tion_table_length

00 02
attributes_count

###### attributes
00001d0行目

00 18
attribute_name_index: 24つ目のコンスタントプールを参照
LineNumberTable

00 00 00 06
attribute_length: 6つ

attribute_name_indexがLineNumberTableのため
4.7.12. The LineNumberTable Attributeを参照

00 01
line_number_table_length

{
00 00
start_pc

00 03
line_number
}

####### attribute2つ目
00 19
attribute_name_index: 25つ目のコンスタントプールを参照
LocalVariableTable

00 00 00 0c
attribute_length: 12つ

attribute_name_indexがLocalVariableTableのため
4.7.13. The LocalVariableTable Attributeを参照

00 01
local_variable_table_length
{
00 00
start_pc

00 05
length

00 1a
name_index: 26つ目のコンスタントプールを参照
this

00 1b
descriptor_index: 27つ目のコンスタントプールを参照
Llang/javactest/Test;

00 00
index: 0
}

#### メソッド2つ目
00001f0行目〜

00 89
access_flags
ACC_PUBLIC(0x0001)
ACC_STATIC(0x0008)
ACC_VARARGS(0x0080)

00 1c
name_index: 28つ目のコンスタントプールを参照
main

00 1d
descriptor_index: 29つ目のコンスタントプールを参照
([Ljava/lang/String;)V

00 01
attributes_count: 1つ

###### attributes
00001f0行目

00 17
attribute_name_index: 23つ目のコンスタントプールを参照
Code

00 00 00 47
attribute_length: 71つ

00 02
max_stack

00 02
max_locals

00 00 00 0b
code_length: 11

###### code
0000200行目

1. 
12 07
ldc #7(String Hello World!)

2.
4c
astore_1

3.
b2 00 09
getstatic #9(Field java/lang/System.out:Ljava/io/PrintStream;)

4.
2b
aload_1

5.
b6 00 0f
invokevirtual #15(Method java/io/PrintStream.println:(Ljava/lang/String;)V)

6.
b1
return

Code終わり

0000210行目

00 00
exception_table_length: 0つ

###### attributes
0000210行目

00 02
attributes_count: ２つ

####### attribute1つ目
00 18
attribute_name_index: 24つ目のコンスタントプールを参照
LineNumberTable

00 00 00 0e
attribute_length: 14つ

00 03
line_number_table_length: 3つ

[
{
00 00
start_pc: 0

00 05
line_number: 5
},
{
00 03
start_pc: 3

00 06
line_number: 6
},
{
00 0a
start_pc: 10

00 07
line_number: 7
}
]

####### attribute2つ目 
00 19
attribute_name_index: 25つ目のコンスタントプールを参照
LocalVariableTable

00 00 00 16
attribute_length: 22つ

00 03
line_number_table_length: 3つ

00 02
local_variable_table_length: 2つ

[
{
00 00
start_pc

00 0b
length: 11つ

00 1e
name_index: 30つ目のコンスタントプールを参照
args

00 1f
descriptor_index: 31つ目のコンスタントプールを参照
[Ljava/lang/String;

00 00
index: 0
},
{
00 03
start_pc

00 08
length: 8つ

00 20
name_index: 32つ目のコンスタントプールを参照
test

00 21
descriptor_index: 33つ目のコンスタントプールを参照
Ljava/lang/String;

00 01
index: 1
}
]


### ClassFile.attributes_count
0000240行目

00 01
attributes_count
1つ

00 22
attribute_name_index: 34つ目のコンスタントプールを参照
SourceFile

00 00 00 02
attribute_length: 2つ

00 23
sourcefile_index: 35つ目のコンスタントプールを参照
Test.java

---
その他メモ

### local_variable_table
Start, Length
変数の有効範囲

Startが開始位置(変数が有効になる箇所定義した箇所)
Lengthが有効期間
Start + Lengthで変数の終了箇所となる。

ここでのインデックスはCode定義のインデックスと一致している。


