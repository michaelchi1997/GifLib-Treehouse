package com.teamtreehouse.giflib.service;

import com.teamtreehouse.giflib.dao.GifDao;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by micha on 2017-08-05.
 */
@Service
public class GifServiceImpl implements GifService{

    @Autowired
    private GifDao gifDao;

    @Override
    public List<Gif> findAll() {
        return gifDao.findAll();
    }

    @Override
    public Gif findById(Long id) {
        return gifDao.findById(id);
    }

    @Override
    public void save(Gif gif, MultipartFile file) {
        try {
            gif.setBytes(file.getBytes());
            gifDao.save(gif);
        } catch (IOException e) {
            System.err.println("Unbale to get byte");
        }
    }

    @Override
    public void toggleFavorite(Gif gif) {
        gif.setFavorite(!gif.isFavorite());
        gifDao.save(gif);
    }

    @Override
    public void delete(Gif gif) {
        gifDao.delete(gif);
    }
}
