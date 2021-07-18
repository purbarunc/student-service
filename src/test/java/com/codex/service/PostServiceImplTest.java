package com.codex.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.codex.model.Post;
import com.codex.model.Users;
import com.codex.repository.PostRepository;

@SpringBootTest
class PostServiceImplTest {
	@InjectMocks
	private PostServiceImpl postServiceImpl;
	@Mock
	private PostRepository postRepository;

	@Test
	@DisplayName("create is successful")
	void create() {
		when(postRepository.save(any())).thenReturn(getPost());
		postServiceImpl.create(mock(Post.class));
		verify(postRepository, times(1)).save(any());
	}

	private Post getPost() {
		return Post.builder().id(100).userPosts("Test  Post").users(mock(Users.class)).build();
	}

}