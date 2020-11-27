@extends('starter')  
  @section('content')
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Danh Sách Phim</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Phim</a></li>
              <li class="breadcrumb-item active">Danh Sách Phim</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <!-- SEARCH FORM -->
            <form class="form-inline ml-3">
              <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                  <button class="btn btn-navbar" type="submit">
                    <i class="fas fa-search"></i>
                  </button>
                </div>
              </div>
            </form>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
              <thead>
                  <tr>
                      <th style="width: 1%">
                          STT
                      </th>
                      <th class="text-center" style="width: 5%">
                          Ảnh
                      </th>
                      <th style="width: 5%">
                          Tên phim
                      </th>
                      <th style="width: 1%">
                          Điểm
                      </th>
                      <th style="width: 1%">
                          Đạo diễn
                      </th>
                      <th style="width: 1%">
                          Diễn viên
                      </th>
                      <th style="width: 8%" class="text-center">
                          Mô tả
                      </th>
                      <th style="width: 5%">
                          Trailer
                      </th>
                      <th style="width: 5%">
                          Thời lượng
                      </th>
                      <th style="width: 5%">
                          Định dạng
                      </th>
                      <th style="width: 5%">
                          Trạng thái
                      </th>
                      <th style="width: 5%">
                          Thể loại
                      </th>
                      <th style="width: 1%">
                      </th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td class="text-center">
                          1
                      </td>
                      <td class="text-center">
                          <img  style="width: 100px" src="{{ asset('public/dist/img/movie_0.jpg') }}">
                      </td>
                      <td class="text-center">
                              Ròm
                      </td>
                      <td class="text-center">
                          10/10
                      </td>
                      <td class="text-center">
                          Victor Vũ
                      </td>
                      <td class="text-center">
                          aaaaaaaa aaaaaaa aaaaaaaa
                      </td>
                      <td class="text-center">
                          aaal dcjc djcj chjccjcn jscjcfe csakjcnjefe ncsjc sjcnsc
                      </td>
                      <td class="text-center">
                          aaaa
                      </td>
                      <td class="text-center">
                          00:45:00
                      </td>
                      <td class="text-center">
                          2D
                      </td>
                      <td class="text-center">
                          Đang chiếu
                      </td>
                      <td class="text-center">
                          Hành động
                      </td>
                      <td class="project-actions text-right">

                          <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-pencil-alt">
                              </i>
                              Edit
                          </a>
                          <a class="btn btn-danger btn-sm" href="#">
                              <i class="fas fa-trash">
                              </i>
                              Delete
                          </a>
                      </td>
                  </tr>
              </tbody>
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  @endsection
