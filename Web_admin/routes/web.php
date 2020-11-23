<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
Route::get('/', function () {
    return view('layouts.login');
});
Route::get('/register', function () {
    return view('layouts.register');
});
Route::get('/layouts/index', function () {
    return view('layouts.index');
});
Route::get('/data/data_khachhang', function () {
    return view('data.data_khachhang');
});
Route::get('/data/data_rap', function () {
    return view('data.data_rap');
});
Route::get('/data/data_phim', function () {
    return view('data.data_phim');
});
Route::get('/data/data_lichchieu', function () {
    return view('data.data_lichchieu');
});
Route::get('/data/data_taikhoan', function () {
    return view('data.data_taikhoan');
});
Route::get('/data/them_khachhang', function () {
    return view('data.them_khachhang');
});
Route::get('/data/them_lichchieu', function () {
    return view('data.them_lichchieu');
});
Route::get('/data/them_rap', function () {
    return view('data.them_rap');
});
Route::get('/data/them_taikhoan', function () {
    return view('data.them_taikhoan');
});
Route::get('/data/them_phim', function () {
    return view('data.them_phim');
});
Route::get('/data/sua_khachhang', function () {
    return view('data.sua_khachhang');
});
Route::get('/data/sua_lichchieu', function () {
    return view('data.sua_lichchieu');
});
Route::get('/data/sua_rap', function () {
    return view('data.sua_rap');
});
Route::get('/data/sua_taiKhoan', function () {
    return view('data.sua_taiKhoan');
});
Route::get('/data/sua_phim', function () {
    return view('data.sua_phim');
});