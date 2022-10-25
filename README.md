## Project Name
TodoApp Backend

## General
Todoアプリを作成しました。

## Technologies
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

## Setup
1.リポジトリをローカル環境にクローン
```
git clone
```
2. DockerFileからDockerイメージを作成して、コンテナを起動させる
```
docker compose up -d
```
3. MySQLにログインする
```
docker compose exec db mysql -u root -p
```
