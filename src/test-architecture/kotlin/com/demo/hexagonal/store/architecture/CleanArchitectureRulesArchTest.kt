package com.demo.hexagonal.store.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures.layeredArchitecture

private const val DOMAIN_LAYER = "domain"
private const val APPLICATION_LAYER = "application"
private const val INFRASTRUCTURE_LAYER = "infrastructure"
private const val DOMAIN_PACKAGE = "com.demo.hexagonal.store.domain.."
private const val APPLICATION_PACKAGE = "com.demo.hexagonal.store.application.."
private const val INFRASTRUCTURE_PACKAGE = "com.demo.hexagonal.store.infrastructure.."
private const val JAVA_SOURCES_PACKAGE = "java.."
private const val KOTLIN_SOURCES_PACKAGE = "kotlin.."
private const val JETBRAINS_SOURCES_PACKAGE = "org.jetbrains.."

@AnalyzeClasses(packages = ["com.demo.hexagonal.store"])
class CleanArchitectureRulesArchTest {

    @ArchTest
    fun `Hexagonal layer should protect clean standard`(javaClasses: JavaClasses) {
        layeredArchitecture()
                .layer(DOMAIN_LAYER).definedBy(DOMAIN_PACKAGE)
                .layer(APPLICATION_LAYER).definedBy(APPLICATION_PACKAGE)
                .layer(INFRASTRUCTURE_LAYER).definedBy(INFRASTRUCTURE_PACKAGE)
                .whereLayer(INFRASTRUCTURE_LAYER).mayNotBeAccessedByAnyLayer()
                .whereLayer(APPLICATION_LAYER).mayOnlyBeAccessedByLayers(INFRASTRUCTURE_LAYER)
                .whereLayer(DOMAIN_LAYER).mayOnlyBeAccessedByLayers(INFRASTRUCTURE_LAYER,
                        APPLICATION_LAYER)
                .check(javaClasses)
    }

    @ArchTest
    fun `Domain should not has external libraries`(javaClasses: JavaClasses) {
        ArchRuleDefinition.classes().that().resideInAPackage(DOMAIN_PACKAGE)
                .should().onlyDependOnClassesThat().resideInAnyPackage(JAVA_SOURCES_PACKAGE,
                        KOTLIN_SOURCES_PACKAGE, DOMAIN_PACKAGE, JETBRAINS_SOURCES_PACKAGE)
                .check(javaClasses)
    }

}