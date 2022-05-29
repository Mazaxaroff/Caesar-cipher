# Caesar-cipher
___
## Краткое описание 
___
### Криптоанализатор "Шифр Цезаря":

#### - Чтение текста из файла, располеженного по пути, указанному пользователем;
#### - Шифрование и расшифровка текстовых файлов с кодировкой UTF8 с текстом на русском языке;
#### - Возможность шифрования и расшифровки с неизвестным ключем;
#### - Запись зашифрованного/расшифрованного текста в файл, расположенному по пути, указанному пользователем.

## Краткое описание классов
___
+ `Main` _- класс запуска программы;_
+ `CipherDecipher` _- основные методы шифровки и дешифровки;_
+ `Converter` _- 4 возможных сценария работы с текстовыми файлами;_
+ `Dialog` _- логика общения с пользователем и набор сообщений;_
+ `PathKeeper` _- методы запроса путей файлов на чтение и запись;_
+ `Lists` _- создание списков строк для чтения и записи файлов;_
+ `Keys` _- запрос ключей шифрования;_
+ `Alfabet` _- список символов алфивита, цифр и знаков пунктуации._
___

## Запуск программы:

[Запуск](./build/Caesar-cipher-v-0-0-1.jar)

$ java -jar ./build/Caesar-cipher-v-0-0-1.jar
___

## Пример выполнения программы:
~~~
Добро пожаловать в мир шифрования!
Вы хотите зашифровать текст?
Введите y или n
Для выхода из программы введите exit
y
У вас есть ключ шифрования?
Введите y или n
Для выхода из программы введите exit
n
Ключ будет сгенерирован случайным образом из диапазона возможных
Пожалуйста введите полный путь к файлу с кодировкой UTF8, из которого требуется обработать текст на русском языке
Для выхода из программы введите exit
..\text.txt
Пожалуйста введите полный путь к файлу в который требуется записать измененный текст
Для выхода из программы введите exit
..\result.txt
Операция успешно завершена! Всего доброго!
~~~

Текст исходного файла:

~~~
Три - эльфийским владыкам в подзвездный предел;
Семь - для гномов царящих в подгорном просторе;
Девять - смертным, чей выведен срок и удел;
И Одно - Властелину на черном престоле.
В Мордоре, где вековечная тьма:
Чтобы всех отыскать, воедино созвать
И единою черною волей сковать
В Мордоре, где вековечная тьма.
~~~

Текст зашифрованного файла:

~~~
6ПЗуоуЬКЫУЗИРЙЗЛуБК ГЪЙ ЛуБуОНГЖБДЖГМЪИуОПДГДКн
5ДЛЫуоуГКЮуВМНЛНБуХ ПЮШЗФуБуОНГВНПМНЛуОПНРСНПДн
шДБЮСЫуоуРЛДПСМЪЛкуЦДИуБЪБДГДМуРПНЙуЗуТГДКн
ьу2ГМНуоуцК РСДКЗМТуМ уЦДПМНЛуОПДРСНКДй
цу0НПГНПДкуВГДуБДЙНБДЦМ ЮуСЫЛ м
,СНАЪуБРДФуНСЪРЙ СЫкуБНДГЗМНуРНЖБ СЫ
ьуДГЗМНЭуЦДПМНЭуБНКДИуРЙНБ СЫ
цу0НПГНПДкуВГДуБДЙНБДЦМ ЮуСЫЛ й
~~~
___

##Ключевые методы:


~~~ java
public static String cihper(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Alfabet.alfabet().contains(ch)) {
                char newChar = Alfabet.alfabet().get((Alfabet.alfabet().indexOf(ch) + shift) % Alfabet.sizeOfAlfabet());
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

public static String decihper(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Alfabet.alfabet().contains(ch)) {
                char newChar = Alfabet.alfabet().get((Alfabet.alfabet().indexOf(ch) + (Alfabet.sizeOfAlfabet()
                        - shift)) % Alfabet.sizeOfAlfabet());
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
~~~