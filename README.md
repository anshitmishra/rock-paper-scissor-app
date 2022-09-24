# rock-paper-scissor-app

This rock paper Scissor app with jetpack compose 

## project screenshot

![screenshoot](https://github.com/anshitmishra/rock-paper-scissor-app/blob/master/images/iamge1.png?raw=true)
![screenshoot](https://github.com/anshitmishra/rock-paper-scissor-app/blob/master/images/image2.png?raw=true)
![screenshoot](https://github.com/anshitmishra/rock-paper-scissor-app/blob/master/images/image3.png?raw=true)

## Common setup

Clone the repo and install the dependencies.

```bash
git clone https://github.com/anshitmishra/rock-paper-scissor-app.git
```

Open Android Studio and create a new project from the just downloaded source.


## Steps for read-only access

Open `gradle.build` in Android Studio and run the app on an emulator or directly on a device.

## Steps for read and write access (recommended)

Step 1: Install the [Contentful CLI](https://www.npmjs.com/package/contentful-cli)

Step 2: Login to Contentful through the CLI. It will help you to create a [free account](https://www.contentful.com/sign-up/) if you don't have one already.

```
contentful login
```

Step 3: Create a new space

```
contentful space create --name 'game app'
```

Step 4: Seed the new space with the content model. Replace the `SPACE_ID` with the id returned from the create command executed in step 3

```
contentful space seed -s '<SPACE_ID>' -t the-example-app
```

Step 5: Head to the Contentful web app's API section and grab `SPACE_ID`, `DELIVERY_ACCESS_TOKEN`, `PREVIEW_ACCESS_TOKEN`.

Step 6: Open <a href="app/build.gradle">app/build.gradle</a> and inject your credentials so it looks like this

```
buildConfigField("String", "CONTENTFUL_DELIVERY_TOKEN", "\"DELIVERY_TOKEN\"")
buildConfigField("String", "CONTENTFUL_PREVIEW_TOKEN", "\"PREVIEW_TOKEN\"")
buildConfigField("String", "CONTENTFUL_SPACE_ID", "\"SPACE_ID\"")
```

<b>Enjoy exploring the app and feel free to leave <a href="https://github.com/anshitmishra/rock-paper-scissor-app/issues/new">feedback</a>.</b>
