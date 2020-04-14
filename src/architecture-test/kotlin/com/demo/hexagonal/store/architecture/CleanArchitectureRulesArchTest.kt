package com.demo.hexagonal.store.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = ["com.demo.hexagonal.store"])
class CleanArchitectureRulesArchTest {

    @ArchTest
    fun `Hexagonal layer definition`(javaClasses: JavaClasses) {
        Architectures.layeredArchitecture().layer("domain")
                .definedBy("com.demo.hexagonal.store.domain..")
                .layer("application").definedBy("com.demo.hexagonal.store.application..")
                .layer("infrastructure").definedBy("com.demo.hexagonal.store.infrastructure..")
                .whereLayer("infrastructure").mayNotBeAccessedByAnyLayer()
                .whereLayer("application").mayOnlyBeAccessedByLayers("infrastructure")
                .whereLayer("domain").mayOnlyBeAccessedByLayers("infrastructure", "application")
                .check(javaClasses)
    }

}