# Errai Revival - Phase 01: Initial Investigation & Environment Setup

This document records the findings, experiments, and progress for Phase 01 of the Errai revival project. The primary goal of this phase is to get the existing Errai codebase (branch `phase01`) to build, pass tests, and run examples.

## Initial Codebase Analysis (Current Step)

### Project Structure and Build System
*   The project is a multi-module [Apache Maven](https://maven.apache.org/) project. This is evidenced by the presence of a root `pom.xml` and `pom.xml` files in numerous subdirectories.
*   The project inherits from a parent POM: `org.jboss:jboss-parent:36`.
    *   According to [mvnrepository.com](https://mvnrepository.com/artifact/org.jboss/jboss-parent/36), this parent POM was published around September 18, 2019.
    *   The specific Java and Maven versions enforced or recommended by this parent POM need further confirmation, but Java 8 is a strong candidate.

### Java Version
*   The primary `pom.xml` includes a Maven profile activated for JDK 9 and newer (`<id>java9+</id>`).
*   Within this profile, the `maven.compiler.release` property is set to `8`.
*   The `maven-compiler-plugin` (version `3.10.1`) is configured with `<release>8</release>`.
*   **Conclusion:** The codebase is intended to be compiled with **Java 8 compatibility**. We will initially target **Java JDK 8 (or a later JDK configured for Java 8 compatibility)** for the build environment.

### Maven Version
*   The `pom.xml` files do not explicitly state a required Maven version.
*   Considering the likely Java 8 target and the 2019 date of the parent POM, **Maven 3.6.x** (a common version around that time) or a later Maven 3.x version is a sensible initial assumption. We will likely start with a recent Maven 3.x version (e.g., 3.8.x, 3.9.x) and adjust if necessary.

### GWT (Google Web Toolkit) Version
*   The project uses the `gwt-maven-plugin` version `2.10.0`.
*   The plugin dependencies explicitly list `org.gwtproject:gwt-dev:2.11.0` and `org.gwtproject:gwt-user:2.11.0`.
*   **Conclusion:** GWT is a core technology. The exact version seems to be GWT 2.11.0, used via the `gwt-maven-plugin` 2.10.0.
    *   GWT 2.10.0 was released around October 2022.
    *   GWT 2.11.0 was released around November 2023.
*   This will be a critical part of the environment setup.

### Next Steps for Investigation
*   Attempt to locate the specific `pom.xml` content for `org.jboss:jboss-parent:36` to confirm its default settings (especially Java version).
*   Proceed to setting up the build environment based on these findings.

---

## Phase 1: Environment Setup and Build (Current Step)

### Environment Configuration

The following development environment has been configured:

*   **Java Development Kit (JDK):**
    *   Version: OpenJDK 1.8.0_452
    *   Verification:
        ```
        openjdk version "1.8.0_452"
        OpenJDK Runtime Environment (build 1.8.0_452-8u452-ga~us1-0ubuntu1~24.04-b09)
        OpenJDK 64-Bit Server VM (build 25.452-b09, mixed mode)
        ```
        ```
        javac 1.8.0_452
        ```

*   **Apache Maven:**
    *   Version: 3.8.7
    *   Verification:
        ```
        Apache Maven 3.8.7
        Maven home: /usr/share/maven
        Java version: 1.8.0_452, vendor: Private Build, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
        Default locale: en, platform encoding: UTF-8
        OS name: "linux", version: "6.8.0", arch: "amd64", family: "unix"
        ```

This setup aligns with the initial investigation, targeting Java 8 and a modern Maven 3.x version.
