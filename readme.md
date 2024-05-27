# Azure OpenAI Content Filtering Demo

![Responsible AI](ResponsibleAI.png)

This project demonstrates the use of Azure OpenAI's content filtering capabilities as part of Microsoft's Responsible AI initiative.

## Table of Contents

- [Project Overview](#project-overview)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview

This project uses the Azure OpenAI SDK to interact with the GPT-4 model. It includes an `Example` class with a main method that sets the Azure log level to INFO, logs the start of the application, retrieves the Azure OpenAI endpoint and key from environment variables, and builds an OpenAIClient with these credentials and log level. The main method then creates a list of ChatMessages, adds a system message stating that the AI is an assistant that helps people find information, and adds a user message with a query. It then creates ChatCompletionsOptions with these messages, gets chat completions from the client using these options and a deployment or model ID, and logs each completion message. Finally, it logs the end of the application.

## Installation

Detailed instructions on how to install, setup, and get the project running.

## Running the Project

Before running the project, ensure that you have set the necessary environment variables for the Azure OpenAI endpoint and key.

1. **Set Environment Variables:** You need to set the following environment variables:
    - `AZURE_OPENAI_ENDPOINT`: The endpoint for the Azure OpenAI service.
    - `AZURE_OPENAI_KEY`: The key for the Azure OpenAI service.

2. **Build the Project:** Navigate to the project directory in your terminal and run the following command to build the project:
    ```bash
    mvn clean install
    ```

3. **Run the Project:** After the build is successful, you can run the project using the following command:
    ```bash
    java -cp target/myproject-1.0-SNAPSHOT.jar com.example.myproject.Example
    ```
Replace `myproject` and `com.example.myproject` with your actual project name and package.

Remember to replace the placeholders with actual content.

## Features

- Azure OpenAI SDK: Interact with the GPT-4 model using Azure's SDK.
- Content Filtering: Demonstrate how to filter content using Azure OpenAI's capabilities.
- Logging: Track the application flow with detailed logging.

## Tests

Instructions on how to run automated tests for the project.

## Contributing

Detailed instructions on how others can contribute to your project, including coding standards and how to submit pull requests.

## License

Specify the license under which your project is distributed. Include a copy of the license if applicable.

## Contact

Your contact information, such as email and social media handles, for people to reach out to you.
