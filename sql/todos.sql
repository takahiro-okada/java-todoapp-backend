DROP TABLE IF EXISTS todos;

  CREATE TABLE todos (
    id int unsigned AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
  );

  INSERT INTO todos (title, description) VALUES ("Javaの勉強","例外処理について本を読む");
  INSERT INTO todos (title, description) VALUES ("書類提出","〇〇さんへ書類を提出する");
  INSERT INTO todos (title, description) VALUES ("旅行の計画","○月○日の旅行の計画をする");
  INSERT INTO todos (title, description) VALUES ("掃除","風呂の掃除をする");

