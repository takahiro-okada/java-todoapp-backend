## プロジェクト
TodoApp Backend

## 概要
Todoアプリを作成しました。

## 使用した技術
### Springbootの設定
| 設定 | 設定値 |
| ---- | ---- |
| Project | Gradle |
| Language | Java | 
| Spring Boot | 2.7.3 |
| Packing | Jav | 
| Java | 17 | 

### インフラ・DB
- AWS(EC2, S3, Route53, ALB, RDS)
- Docker
- MySQL 5.7

## 設計書
### ER図
準備中

### URL一覧
準備中

### API仕様
準備中

### インフラ構成図
準備中

## 設定
1.リポジトリをローカル環境にクローン
```
git clone
```
2. DockerFileからDockerイメージを作成して、コンテナを起動させる
```
docker compose up -d
```
3. MySQLにログインする（DBの中身を確認したいときに使用する）
```
docker compose exec db mysql -u root -p
```
