package com.example.Pet_Adoption_System.Security.Services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Pet_Adoption_System.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;