Feature: Create the technical design of a OneCraft Project

  Scenario: A tech lead designs a new project
    Given A project manager creates a new project
    When The project manager gives valid requirements
    Then The solution architect should produce a valid technical design

  Scenario: A tech lead designs a new project
    Given A project manager creates a new project
    When The project manager gives invalid requirements
    Then The solution architect should fail to produce the design