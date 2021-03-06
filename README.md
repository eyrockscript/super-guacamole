# super-guacamole
 _recaptcha v3 -> spring(boot + aop) + angular + jquery_

[![Build Status](https://www.travis-ci.com/eyrockscript/super-guacamole.svg?branch=main)](https://www.travis-ci.com/eyrockscript/super-guacamole)
[![CircleCI](https://circleci.com/gh/eyrockscript/super-guacamole/tree/main.svg?style=svg)](https://circleci.com/gh/eyrockscript/super-guacamole/tree/main)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=eyrockscript_super-guacamole&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=eyrockscript_super-guacamole)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=eyrockscript_super-guacamole&metric=bugs)](https://sonarcloud.io/dashboard?id=eyrockscript_super-guacamole)

## create site keys
https://www.google.com/recaptcha/admin

## spring app
### 1. open application.yml file
```sh
vi src/main/resources/application.yml
```
### 2. Add your secret key
``` yaml
google:
 recaptcha:
  secret: [YOUR_SECRET_KEY]
```
## 3. init spring app
```sh
gradle bootRun
```

## angular app
### 1. open html file
``` sh
vi src/main/resources/static/spring-recaptcha-v3/src/app/app.component.html
```
### 2. Add your site key
``` html
<div>
     <input type="text" id="name"/>
     <button
        id="button"
        type="submit"
        class="g-recaptcha"
        data-sitekey="[YOUR_SITE_KEY]">Hello</button>
 </div>
```

### 3. init app
```sh
cd src/main/resources/static/spring-recaptcha-v3/
ng s
```

