# AlibiKun
RPAにより定期的にマウスカーソルを移動します

## purpose

Windows端末においてスクリーンロック時間を管理できない（権限により変更できない）状況下で、
本ツールによりマウスがグリグリ動くことで、スクリーンロックされなくなります。

## how to use

1. build/libs/AlibiKun-x.x.x-yyyy.jarをダブルクリック

1. java -jar ${JAR PATH}/AlibiKun-x.x.x-yyyy.jar  
※1分ごとに起動

1. java -jar ${JAR PATH}/AlibiKun-x.x.x-yyyy.jar ＜INTEGER＞   
※指定した時間（分）ごとに起動

## how to build

./gradlew shadowJar

## memo

ライブラリを利用したRPAツールです。
