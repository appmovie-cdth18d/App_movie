<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
class TrangThaiPhim extends Model
{
    use SoftDeletes;

    protected $dates = ['deleted_at'];
    
    protected $fillable = ['Tentrangthai'];

    public function phims(){
    	return $this->hasMany('Model\Phim','trangthai_id','id');
    }
}
