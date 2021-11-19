package com.revature.services;

import	com.revature.models.Profile;
import	com.revature.repositories.ProfileRepo;
import	org.junit.jupiter.api.*;
import	org.mockito.InjectMocks;
import	org.mockito.Mock;
import	org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import	static	org.junit.jupiter.api.Assertions.*;
import	static	org.mockito.Mockito.when;

public class ProfileServiceTest {
<<<<<<< HEAD
    private final String pass = "c8ZLBnfDh3YsvZ2dW1KDWY6ZTak8+v+/L74e8Vfoydk1IfySsVCAZVKTZfrtPKodzUXEiR+69yjOz1qqf7U4" +
            "rA==jnW2sIxW7inUlQqGJCNrNa7Eavj5uMGQAYZ0S6xNz65p79QaOk8eZpOChJlFPvIadohhOuHg5PFGeewM2YmkVR260YPhJwK/GUR3" +
            "YXsUH0+KjOQKuHAHY8CyLwpBsNV0DsPO56jn2As1CfBMJc9VSNsx37W4Vo5MCaOTisZwBWjUsTG9i+HecqcK9C0tIWC2Jn44oX5BAS31" +
            "Huev/ZIWf2OE3FjHSMLyJs0TmJAPxBg6IllwEhv75+ffGbZENZVkkHV3LRxUWKtGdQa5tSOt6pdzIZtdSO6o81zXD6BBDfEZo22qCVCR" +
            "2C2DQbsmaMJhInHwxEZ3RS3/1N+rz85STq/h+nKvqBcoPOFfq0o5tRRnOlRVFpWuONhiY7IUSqtTZCJmqHnALSRFJwMGFPjmUkq1nQxu" +
            "x1rgxllacVb+AT4bS+Xbw8DyUwGepmTCiw4t75krGyCSBArcmfiFBtgDkVZTFIJ+GMFhFbpWv2darLcxKlgSdur/z9YCYoZcKm9vrrH+" +
            "CaFykfIUdjnln5jhLoRmjeBIHgYWITG5J5/NCzAM+a3k4Y92/hbgDDE15GD1ud1EU8GHY4eb5LU1pAb2O7zbcW9pQbtVcbqyJGNRFA6O" +
            "AGcWb1R0+04d0+1DA6BjTDsxkltgsvUpLrVFBo4VaFAT6Jf4ZI2Pg39WjFY1an8=";
=======
    String pass = "c8ZLBnfDh3YsvZ2dW1KDWY6ZTak8+v+/L74e8Vfoydk1IfySsVCAZVKTZfrtPKodzUXEiR+69yjOz1qqf7U4rA==jnW2sIxW7inUlQqGJCNrNa7Eavj5uMGQAYZ0S6xNz65p79QaOk8eZpOChJlFPvIadohhOuHg5PFGeewM2YmkVR260YPhJwK/GUR3YXsUH0+KjOQKuHAHY8CyLwpBsNV0DsPO56jn2As1CfBMJc9VSNsx37W4Vo5MCaOTisZwBWjUsTG9i+HecqcK9C0tIWC2Jn44oX5BAS31Huev/ZIWf2OE3FjHSMLyJs0TmJAPxBg6IllwEhv75+ffGbZENZVkkHV3LRxUWKtGdQa5tSOt6pdzIZtdSO6o81zXD6BBDfEZo22qCVCR2C2DQbsmaMJhInHwxEZ3RS3/1N+rz85STq/h+nKvqBcoPOFfq0o5tRRnOlRVFpWuONhiY7IUSqtTZCJmqHnALSRFJwMGFPjmUkq1nQxux1rgxllacVb+AT4bS+Xbw8DyUwGepmTCiw4t75krGyCSBArcmfiFBtgDkVZTFIJ+GMFhFbpWv2darLcxKlgSdur/z9YCYoZcKm9vrrH+CaFykfIUdjnln5jhLoRmjeBIHgYWITG5J5/NCzAM+a3k4Y92/hbgDDE15GD1ud1EU8GHY4eb5LU1pAb2O7zbcW9pQbtVcbqyJGNRFA6OAGcWb1R0+04d0+1DA6BjTDsxkltgsvUpLrVFBo4VaFAT6Jf4ZI2Pg39WjFY1an8=";
>>>>>>> 4161c9537f5057c89edc963669dffb607607079e
    List<Profile> pList = new ArrayList<>();

    @Mock
    ProfileRepo profileRepo;

    @InjectMocks
    private  ProfileServiceImpl profileService;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccess(){
        Profile expected = new Profile(12, "joey", pass, "Joe", "Seph", "a@b.com", pList);
        when(profileRepo.getProfileByUsername("joey")).thenReturn(expected);
        Profile actual = profileService.login("joey","abc123");
        assertEquals(expected,actual);
    }

    @Test
    void testLoginNullUsername(){
        when(profileRepo.getProfileByUsername(null)).thenReturn(null);
        Profile actual = profileService.login(null,"abc123");
        assertNull(actual);
    }

    @Test
    void testLoginNullPass(){
        Profile expected = new Profile(12, "joey", pass, "Joe", "Seph", "a@b.com", pList);
        when(profileRepo.getProfileByUsername("joey")).thenReturn(expected);
        Profile actual = profileService.login("a@b.com",null);
        assertNull(actual);
    }

    @Test
    void testLoginBadUsername(){
        Profile expected = new Profile(12, "joey", pass, "Joe", "Seph", "a@b.com", pList);
        when(profileRepo.getProfileByUsername("banana")).thenReturn(null);
        Profile actual = profileService.login("banana","tomato");
        assertNull(actual);
    }

    @Test
    void testLoginBadPass(){
        Profile expected = new Profile(12, "joey", pass, "Joe", "Seph", "a@b.com", pList);
        when(profileRepo.getProfileByUsername("a@b.com")).thenReturn(expected);
        Profile actual = profileService.login("a@b.com","tomato");
        assertNull(actual);
    }

    @Test
    void testFindProfileByUsernameSuccess(){
        Profile expected = new Profile(12, "joey", pass, "Joe", "Seph", "a@b.com", pList);
        when(profileRepo.getProfileByUsername("joey")).thenReturn(expected);
        Profile actual = profileRepo.getProfileByUsername("joey");
        assertEquals(actual,expected);
    }

    @Test
    void testFindProfileByUsernameNullEntry(){
        when(profileRepo.getProfileByEmail(null)).thenReturn(null);
        Profile actual = profileRepo.getProfileByEmail((null));
        assertNull(actual);
    }

    @Test
    void testFindProfileByUsernameBadEntry(){
        when(profileRepo.getProfileByEmail("FloppyDisk")).thenReturn(null);
        Profile actual = profileRepo.getProfileByEmail(("FloppyDisk"));
        assertNull(actual);
    }

    @Test
    public void addnewProfile()
    {
        Profile profile = new Profile();
        profile.setFirstName("Bob");
        profile.setLastName("Square");
        profile.setEmail("bikini@bottom.net");
        profile.setUsername("SBob");
        profile.setPasskey("secret");

        when(profileRepo.save(profile)).thenReturn(profile);
        assertEquals(profile, profileService.addNewProfile(profile));

    }

    @Test
    public void getProfileByUser()
    {
        Profile profile = new Profile(1,"user","1234","f","l","em", pList);
        when(profileRepo.getProfileByEmail(profile.getEmail())).thenReturn(profile);
        Profile actual = profileService.getProfileByEmail(profile.getEmail());
        assertEquals(profile,actual);
    }

    @Test
    public void testGetExistingProfile(){
        Profile expected = new Profile(1,"test","1234","test","test","test@mail", pList);
        when(profileRepo.getProfileByPid(1)).thenReturn(expected);
        assertEquals(expected, profileService.getProfileByPid(1));
    }


    @Test
    public void testGetInvalidProfile(){
        when(profileRepo.getProfileByPid(1)).thenReturn(null);
        assertNull(profileService.getProfileByPid(1));
    }

    @Test
    public void testUpdateExistingProfile(){
        Profile expected = new Profile(1,"test","1234","updateTest","updateTest","test@mail", pList);
        Profile old = new Profile(1,"test","1234","test","test","test@mail", pList);
        when(profileRepo.getProfileByPid(1)).thenReturn(old);
        when(profileRepo.save(old)).thenReturn(old);
        assertEquals(expected, profileService.updateProfile(expected));
    }

    @Test
    public void testUpdateInvalidProfile(){
        Profile profile = new Profile(1,"test","1234","updateTest","updateTest","test@mail", pList);
        when(profileRepo.getProfileByPid(1)).thenReturn(null);
        when(profileRepo.save(null)).thenReturn(null);
        assertNull(profileService.updateProfile(profile));
    }
}
